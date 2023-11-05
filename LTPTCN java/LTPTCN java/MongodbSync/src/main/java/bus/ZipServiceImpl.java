package bus;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import dao.ZipDao;
import entity.Zip;
import util.Mapper;

public class ZipServiceImpl implements ZipService {
	private ZipDao zipDao;

	public ZipServiceImpl() {
		zipDao = new ZipDao();
	}

	@Override
	public boolean addZip(Zip zip) {

		Document doc = Mapper.toDocument(zip);

		return zipDao.addZip(doc);
	}

	public boolean deleteZip(Zip zip) {
		return false;
	}

	@Override
	public List<Zip> getZipsByCity(String city) {
		if (city == null || city.trim().equals(""))
			return null;

		List<Document> zips = zipDao.getZipsByCity(city);

		return zips.stream().map(zip -> {
			return Mapper.fromDocument(zip);
		}).toList();
	}

	@Override
	public boolean updateZip(Zip zipNew) {
		Document doc = Mapper.toDocument(zipNew);
		return zipDao.updateZip(doc);
	}

	

// Cau 1
	@Override
	public List<Zip> listDocument() {
		List<Document> document = zipDao.getDocment();
		return document.stream().map(doc -> {
			return Mapper.fromDocument(doc);
		}).toList();
	}

	
//Cau 5
	@Override
	public List<Zip> getZipsByPop(int pop) {
		List<Document> document = zipDao.getZipsByPop(pop);
		return document.stream().map(doc -> {
			return Mapper.fromDocument(doc);
		}).toList();
	}

//Cau7
	@Override
	public List<String> getCityByPop() {
		List<Document> city = zipDao.getCityByPop();

		return city.stream().map(doc -> {
			return doc.getString("city");
		}).toList();
	}
//Cau8
	@Override
	public List<String> getCityByStateAndPop(String state, int pop) {
		List<Document> states = zipDao.getCityByStateAndPop(state,pop);

		return states.stream().map(doc -> {
			return doc.getString("city");
		}).toList();
	}
	//Cau9
	@Override
	public List<String> getStates() {
		List<Document> states = zipDao.getStates();

		return states.stream().map(doc -> {
			return doc.getString("_id");
		}).toList();
	}
//Cau12
	@Override
	public List<Zip> getDocByStateAndCity(String state, String city) {
		List<Document> document = zipDao.getDocByStateAndCity(state,city);
		return document.stream().map(doc -> {
			return Mapper.fromDocument(doc);
		}).toList();
	}
//Cau11
	@Override
	public List<Document> getAvgByState() {
		List<Document>documents = zipDao.getAvgByState();
		return documents.stream().map(doc->{
			doc.getString("_id");
			doc.getInteger("pop");
			return doc;
		}).toList();
	}
//Cau13
@Override
public List<Document> getCountCityByState() {
	List<Document> count = zipDao.getCountCityByState();
	return count.stream().map(doc -> {
		doc.getInteger("city");
		return doc;
	}).toList();
	
}

@Override
public List<Document> getCountCityByStateSort() {
	List<Document> count = zipDao.getCountCityByStateSort();
	return count.stream().map(doc->{
		doc.getInteger("city");
		return doc;
	}).toList();

}

@Override
public List<Document> getStateBy1000000(int pop) {
	List<Document> state = zipDao.getStateBy1000000(pop);
	return state.stream().map(doc->{
		doc.getString("state");
		doc.getInteger("pop");
		return doc;
	}).toList();
}

@Override
public List<Zip> updateID(ObjectId id) {
	return null;
}
//Cau 6
@Override
public List<Document> getPopByCity(String city) {
	List<Document> ct = zipDao.getPopByCity(city);
	return ct.stream().map(doc->{
		doc.getInteger("pop");
		return doc;
	}).toList();
}

	


}
