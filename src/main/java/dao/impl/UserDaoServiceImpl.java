package dao.impl;

import model.Student;
import dao.UserDaoService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;


@Repository
public class UserDaoServiceImpl implements UserDaoService {

    @Override
    public Student getUserInformation(String id) {

        //return MongoUtil.findWithId(id);
    	
    	Student stu = new Student();
    	stu.setId(12);
    	stu.setStudentName("Ricky");
    	Map<String, Double> map = new HashMap<>();
    	map.put("Ricky", 89.5);
    	stu.setScores(map);
    	return stu;
    }
}
