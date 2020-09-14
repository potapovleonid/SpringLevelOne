import domain.Employee;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AppSQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager em = emf.createEntityManager();

        Employee employee = new Employee();
        Employee employee1 = new Employee();
        employee1.setFullname("Agapov Denis");
        employee.setFullname("Potapov Leonid");

        createEmployee(em, employee);
        createEmployee(em, employee1);

    }

    private static void createEmployee(EntityManager em, Employee employee){
        System.out.println("Create employee");
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        System.out.println("Complete transaction add employee");
    }

    private static Employee findEmployee(EntityManager em, Long id){
        System.out.println("Start find person id: " + id);
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, id);
        em.getTransaction().commit();
        System.out.println("Find complete");
        return employee;
    }

    private static void saveEmployee(EntityManager em, Employee employee){
        System.out.println("Start save employee");
        em.getTransaction().begin();
        Employee saveEmployee = em.merge(employee);
        em.getTransaction().commit();
        System.out.println("Complete save employee" + saveEmployee);
    }
}
