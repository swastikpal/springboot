package service.impl;

import model.Student;
import dao.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoService userDaoService;

    @Override
    public Student getUserInformation(String id) {
        return userDaoService.getUserInformation(id);
    }
}
