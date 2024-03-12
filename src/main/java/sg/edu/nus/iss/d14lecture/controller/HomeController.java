package sg.edu.nus.iss.d14lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/home")
public class HomeController {
    
    @GetMapping("/pagea")
    public String pageA(Model model) {
        
        // goto pagea.html
        return "pagea";
    }

    @PostMapping("/pagea")
    public String postPageA(@RequestBody MultiValueMap<String, String> form, HttpSession httpSession, Model model) {
        String fullname = form.getFirst("fullname");

        httpSession.setAttribute("fullname", fullname);

        model.addAttribute("fullname", httpSession.getAttribute("fullname"));
        // got to pageb.html
        return "pageb";
    }

    @GetMapping("/pagec")
    public String navigatetoPageC(HttpSession httpSession, Model model) {
        String fullname = httpSession.getAttribute("fullname").toString();

        model.addAttribute("fullname", fullname);
        return "pagec";
    }

    @GetMapping("/page0")
    public String redirectBacktoPageA(HttpSession httpSession) {
        httpSession.invalidate();

        return "redirect:/home/pagea";
    }
    
    
    
}
