package dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import entity.Location;
import entity.Zip;

public class Mapper {

	public static Zip fromDocument(Document doc) {
		
		Document locDoc = doc.get("loc", Document.class);
		Location loc = new Location(locDoc.getDouble("y"), locDoc.getDouble("x"));
		
		Zip zip = new Zip();
		zip.setId(doc.getObjectId("_id"));
		zip.setCity(doc.getString("city"));
		zip.setLocation(loc);
		zip.setZip(doc.getString("zip"));
		zip.setPop(doc.getInteger("pop"));
		zip.setState(doc.getString("state"));
		
		return zip;
	}

	public static Document toDocument(Zip zip) {
		
		Document locDoc = new Document("y", zip.getLocation().getY())
				.append("x", zip.getLocation().getX());
		
		Document doc = new Document();
		doc
		.append("city", zip.getCity())
		.append("zip", zip.getZip())
		.append("loc", locDoc)
		.append("pop", zip.getPop())
		.append("state", zip.getState());
		
		return doc;
	}

	public static List<Document> toDocuments(List<Zip> zips) {
		
		List<Document> docs = new ArrayList<Document>();
		
		for(Zip zip : zips)
			docs.add(toDocument(zip));
		
		return docs;
	}
	
}
