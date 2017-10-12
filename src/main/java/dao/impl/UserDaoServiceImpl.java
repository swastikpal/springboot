package dao.impl;

import model.Student;
import dao.UserDaoService;
import org.springframework.stereotype.Repository;
import util.MongoUtil;

@Repository
public class UserDaoServiceImpl implements UserDaoService {

    @Override
    public Student getUserInformation(String id) {

        return MongoUtil.findWithId(id);
    }
}
