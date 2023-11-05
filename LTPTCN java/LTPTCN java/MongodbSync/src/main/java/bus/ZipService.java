package bus;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import entity.Zip;

public interface ZipService {
	public boolean addZip(Zip zip);
//	Tìm các document có city là PALMER
	public List<Zip> getZipsByCity(String city);
	public boolean updateZip(Zip zipNew) ;
	//Liệt kê danh sách các state, không trùng
	
	//Cau 1
	public List<Zip> listDocument();
	//cau3
	public List<Zip>updateID(ObjectId id);
	//Cau 5
	public List<Zip>getZipsByPop(int pop);
	//Cau 6
	public List<Document>getPopByCity(String city);
	//Cau7
	public List<String> getCityByPop();
	//Cau8
	public List<String> getCityByStateAndPop(String state, int pop);
	//Cau9
	public List<String> getStates() ;
	//Cau11
	public List<Document> getAvgByState();
	//Cau12
	public List<Zip> getDocByStateAndCity(String state, String city);
	//Cau13
	public List<Document> getCountCityByState();
	//Cau14
	public List<Document>getCountCityByStateSort();
	//Cau15
	public List<Document>getStateBy1000000(int pop);
}
