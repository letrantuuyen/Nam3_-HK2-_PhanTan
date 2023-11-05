package util;

import org.bson.Document;

import entity.Location;
import entity.Zip;

public class Mapper {
	
	public static Zip fromDocument(Document doc) {
		
		Document locDoc = (Document) doc.get("loc");
		Location loc = new Location(locDoc.getDouble("y"),
				locDoc.getDouble("x"));
		
		return new Zip(
				doc.getObjectId("_id"),	
				doc.getString("city"), 
				doc.getString("zip"), 
				loc, 
				doc.getInteger("pop"), 
				doc.getString("state"));
	}
	
	public static Document toDocument(Zip zip) {
		
		Location loc = zip.getLoc();
		Document locDoc = new Document("y", loc.getY())
				.append("x", loc.getX());
		
		return new Document("_id", zip.getId())
				.append("city", zip.getCity())
				.append("zip", zip.getZip())
				.append("loc", locDoc)
				.append("pop", zip.getPop())
				.append("state", zip.getState());
	}
}
