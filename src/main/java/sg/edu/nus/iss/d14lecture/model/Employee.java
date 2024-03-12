package sg.edu.nus.iss.d14lecture.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Employee {
    
    private String id;

    @NotEmpty(message = "First Name is manadatory")
    @Size(min = 5, max = 15, message = "First Name must be between 5 and 15 characters")
    private String firstName;


    @NotEmpty(message = "Last Name is manadatory")
    @Size(min = 5, max = 15, message = "Last Name must be between 5 and 15 characters")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birth date cannot be a present or future date")
    private Date birthday;

    @Min(value = 1500, message="Minimum salary starts from 1500")
    @Max(value = 50000, message="Maximum salary cannot exceeds 50000")
    private Integer salary;

    @Email(message = "Invalid Email format")
    @Size(max = 30, message = "Email length cannot exceed 30 characters")
    @NotBlank(message = "Email cannot be empty or blank")
    private String email;

    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Invalid phone number entered")
    private String phoneNo;

    @Digits(fraction = 0, integer = 6, message = "Postal code formate must be 6 digits")
    @Min(value = 111111, message="Postal Code starts from 111111")
    @Max(value = 888888, message="Postal Code cannot exceeds 888888")
    private Integer PostalCode;
    
    public Employee() {
    }

    public Employee(String firstName, String lastName, Date birthday, Integer salary, String email, String phoneNo,
            Integer postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.salary = salary;
        this.email = email;
        this.phoneNo = phoneNo;
        PostalCode = postalCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(Integer postalCode) {
        PostalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
                + ", salary=" + salary + ", email=" + email + ", phoneNo=" + phoneNo + ", PostalCode=" + PostalCode
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
        result = prime * result + ((PostalCode == null) ? 0 : PostalCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (birthday == null) {
            if (other.birthday != null)
                return false;
        } else if (!birthday.equals(other.birthday))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (phoneNo == null) {
            if (other.phoneNo != null)
                return false;
        } else if (!phoneNo.equals(other.phoneNo))
            return false;
        if (PostalCode == null) {
            if (other.PostalCode != null)
                return false;
        } else if (!PostalCode.equals(other.PostalCode))
            return false;
        return true;
    }



    
}
