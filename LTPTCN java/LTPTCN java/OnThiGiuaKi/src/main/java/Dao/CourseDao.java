package Dao;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import Connection.AtlasConnection;
import Connection.Mapper;
import Entity.Course;

public class CourseDao {
	private MongoCollection<Document> courDao;
	public CourseDao() {
		courDao = AtlasConnection.getInstance()
				.getMongoClient()
				.getDatabase("ThiGK")
				.getCollection("courses");
	}
	public long addCourse(List<Course> courses) {
		InsertOneResult result = null;
		long i =0;
		for(Course cour : courses) {
			Document doc = Mapper.toDoc(cour);
			result = courDao.insertOne(doc);
			i++;
		}
		return i;
	}
	public boolean deleteCourse(String id) {
		DeleteResult result = courDao.deleteOne(Filters.eq(id));
		return result != null;
	}
	public boolean updateCourse(String id,String title) {
		Bson find = new Document("_id", id);
		//{$set:{'title':'near'}
		Bson update = new Document("$set",new Document("title",title));
		UpdateResult result = courDao.updateOne(find, update);
		return result != null;
	}
//	db.courses.aggregate([{$lookup:{from:'students',localField:'_id',foreignField:'registeredCourses.courseId',as:'stu_list'}},{$unwind:'$stu_list'},{$match:{'stu_list.registeredCourses.letterGrade':'A+'}},{$group:{_id:'$_id',TongA:{$sum:1}}},{$group:{_id:null,Max:{$max:'$TongA'}}},{$unset:'stu_list'}])
}
