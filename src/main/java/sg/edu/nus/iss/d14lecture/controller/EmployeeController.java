package sg.edu.nus.iss.d14lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.d14lecture.model.Employee;


@Controller
@RequestMapping(path = "/employees")
public class EmployeeController {
    
    // http://localhost:<port no>/employees/add
    @GetMapping("/add")
    public String employeeAdd(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employeeNew", employee);

        // have a employeeadd.html in resources/templates folder
        return "employeeadd";
    }
}
