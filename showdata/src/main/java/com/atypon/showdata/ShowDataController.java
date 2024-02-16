package com.atypon.showdata;

import com.atypon.showdata.model.AnalyticsResult;
import com.atypon.showdata.repository.AnalyticsResultRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class ShowDataController {
    private final RestTemplate restTemplate;
    private final AnalyticsResultRepository analyticsResultRepository;

    @Autowired
    public ShowDataController(RestTemplate restTemplate, AnalyticsResultRepository analyticsResultRepository) {
        this.restTemplate = restTemplate;
        this.analyticsResultRepository = analyticsResultRepository;
    }

    @GetMapping("/")
    public String welcome() {
        return "login";
    }

    @PostMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message;
        String uri = "http://authentication:7070/show-results?username=" + username + "&password=" + password;
        Boolean result = restTemplate.getForObject(uri, Boolean.class);
        if (Boolean.TRUE.equals(result)) {
            List<AnalyticsResult> results = analyticsResultRepository.findAll();
            return new ModelAndView("data", "results", results);

        } else {
            message = "Wrong username or password.";
            return new ModelAndView("login",
                    "name", message);
        }
    }

    @GetMapping("/analytics")
    public String showAnalytics(Model model) {
        List<AnalyticsResult> results = analyticsResultRepository.findAll();
        model.addAttribute("results", results);
        return "data";
    }

}
