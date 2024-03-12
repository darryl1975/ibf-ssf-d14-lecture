package sg.edu.nus.iss.d14lecture.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import sg.edu.nus.iss.d14lecture.model.Employee;
import sg.edu.nus.iss.d14lecture.repo.EmployeeRepo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping(path = "/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeRepo empRepo;

    // http://localhost:<port no>/employees/add
    @GetMapping("/add")
    public String employeeAdd(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employeeNew", employee);

        // have a employeeadd.html in resources/templates folder
        return "employeeadd";
    }

    @PostMapping("/add")
    public String saveEmployee(@Valid @ModelAttribute("employeeNew") Employee employeeForm, BindingResult result, Model model) throws FileNotFoundException {

        if (result.hasErrors()) {
            return "employeeadd";
        }

        // perform some operations
        // i.e. save to a file or database
        // redirect to success page
        empRepo.save(employeeForm);

        model.addAttribute("savedEmployee", employeeForm);
        return "success";
    }


    @GetMapping("/list")
    public String EmployeeList(Model model) {

        List<Employee> employees = empRepo.findAllEmployees();
        model.addAttribute("employees", employees);

        return "employeelist";
    }

    @GetMapping("/delete/{email}")
    public String deleteEmployee(@PathVariable("email") String email) {
        Employee employee = empRepo.findByEmail(email);

        Boolean isDeleted = empRepo.deleteEmployee(employee);

        return "redirect:/employees/list";
    }
    
}
