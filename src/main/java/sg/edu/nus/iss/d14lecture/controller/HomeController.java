package sg.edu.nus.iss.d14lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/home")
public class HomeController {
    
    @GetMapping("/pagea")
    public String pageA(Model model, HttpSession httpSession) {
        
        return "pagea";
    }
}
