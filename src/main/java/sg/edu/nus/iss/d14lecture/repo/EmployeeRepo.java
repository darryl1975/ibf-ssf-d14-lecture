package sg.edu.nus.iss.d14lecture.repo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.d14lecture.model.Employee;

@Repository
public class EmployeeRepo {
    
    // Windows: c:\\data
    // macOS: /Users/darryl/data
    final String dirPath = "/Users/darryl/data";

    final String fileName = "employee.txt";

    private List<Employee> employees;
    

    public EmployeeRepo() throws ParseException {

        if (employees == null) {
            employees = new ArrayList<>();
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date birthDate = df.parse("1977-08-09");
        Employee emp = new Employee("Walter", "Loo", birthDate, 22000, "walterloo@nus.edu.sg", "97304666", 119615);
        employees.add(emp);

        birthDate = df.parse("1975-12-19");
        emp = new Employee("James", "Khoo", birthDate, 8000, "jameskhoo@nus.edu.sg", "91234567", 119615);
        employees.add(emp);
    }

    public List<Employee> findAllEmployees() {
        return employees;
    }

    public Boolean save(Employee employee) throws FileNotFoundException {
        Boolean isSaved = false;

        // add the new employee record to the List<Employee> object
        employees.add(employee);

        // open a file stream to write the new employee record to a file
        File file = new File(dirPath + "/" + fileName);
        OutputStream os = new FileOutputStream(file, true);
        PrintWriter pw = new PrintWriter(os);
        pw.println(employee.toString());
        pw.flush();
        pw.close();

        return isSaved;
    }

    public Employee findByEmail(String email) {
        Employee retrievedEmployee = employees.stream().filter(emp -> emp.getEmail().equals(email)).findFirst().get();

        return retrievedEmployee;
    }


    public Boolean deleteEmployee(Employee employee) {
        // returns true means successfully deleted, returns false means delete unsuccessful
        Boolean isDeleted = false;

        int indexValue = employees.indexOf(employee);

        // record found in array (array starts from position 0)
        // -1 means not found
        if (indexValue >= 0) {
            employees.remove(indexValue);
            isDeleted = true;
        } 
        
        return isDeleted;
    }
}
