package domain;

import javax.persistence.*;

@Entity
@Table(name = "employees_tbl")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "fullname_fld")
    private String fullname;

//    @OneToOne
//    @JoinColumn(name = "employee_details_id")
//    private EmployeeDetails employee_details;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

//    public EmployeeDetails getEmployee_details() {
//        return employee_details;
//    }

//    public void setEmployee_details(EmployeeDetails employee_details) {
//        this.employee_details = employee_details;
//    }
}
