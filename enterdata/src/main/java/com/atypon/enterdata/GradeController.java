package com.atypon.enterdata;

import com.atypon.enterdata.model.Grade;
import com.atypon.enterdata.repository.GradeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GradeController {
    private final RestTemplate restTemplate;
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeController(RestTemplate restTemplate, GradeRepository gradeRepository) {
        this.restTemplate = restTemplate;
        this.gradeRepository = gradeRepository;
    }

    @GetMapping("/")
    public String welcome() {
        return "login";
    }

    @PostMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message;
        String uri = "http://authentication:7070/show-results?username=" + username + "&password=" + password;
        Boolean result = restTemplate.getForObject(uri, Boolean.class);
        if (Boolean.TRUE.equals(result)) {
            return new ModelAndView("add-grades",
                    "name", username);

        } else {
            message = "Wrong username or password.";
            return new ModelAndView("login",
                    "name", message);
        }
    }

    @PostMapping(value = "/add")
    public ModelAndView addGrade(HttpServletRequest request,
                                 HttpServletResponse response) {
        String studentName = request.getParameter("studentName");
        int grade = Integer.parseInt(request.getParameter("grade"));
        Grade gradeObject = new Grade();
        gradeObject.setGrade(grade);
        gradeObject.setStudentName(studentName);
        gradeRepository.save(gradeObject);
        return new ModelAndView("add-grades", "message", "ADDED");

    }
}
