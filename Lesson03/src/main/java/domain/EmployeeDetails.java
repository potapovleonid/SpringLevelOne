package domain;

import javax.persistence.*;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

    @Id
    @GeneratedValue
    @Column(name = "employee_details_id")
    private Integer id;

    @Column
    private String title;

    @OneToOne(mappedBy = "employee_details")
    private Employee employee;
}
