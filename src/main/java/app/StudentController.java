package app;

import model.Student;
import model.Welcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
public class StudentController {

    /**
     *
     */
    @Autowired
    UserService userService;

    @RequestMapping(value = "/fetch")
    public Welcome getData(@RequestParam(value="name", defaultValue="World") String name) {
        return new Welcome(1, "Welcome to spring boot");
    }

    @RequestMapping(value = "/getUser")
    public Student getUserData(@RequestParam(value = "id") String id) {
        return userService.getUserInformation(id);
    }
}
