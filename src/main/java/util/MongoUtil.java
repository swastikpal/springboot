package util;

import model.Student;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MongoUtil {

    public static MongoClient getMongoClient() {
        return new MongoClient("localhost", 27017);
    }

    public static MongoDatabase getMongoDatabase(MongoClient mongoClient, String databaseName) {
        return mongoClient.getDatabase(databaseName);
    }

    public static Student findWithId(String id) {
        Student finalStudent = new Student();
        MongoDatabase database = getMongoDatabase(getMongoClient(), "school");
        MongoCollection<Document> collection = database.getCollection("students");

        Bson filter = eq("_id", Integer.parseInt(id));

        List<Document> students = collection.find(filter).into(new ArrayList<Document>());

        for (Document student : students) {
            finalStudent.setId(student.getInteger("_id"));
            finalStudent.setStudentName(student.getString("name"));

            List<Document> scores = (List<Document>) student.get("scores");

            for(Iterator<Document> iterator = scores.iterator(); iterator.hasNext();) {
                Document score = iterator.next();
                finalStudent.getScores().put(score.getString("type"), score.getDouble("score"));
            }
        }
        return finalStudent;
    }

}
