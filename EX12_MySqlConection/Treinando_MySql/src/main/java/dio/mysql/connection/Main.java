package dio.mysql.connection;

import dio.mysql.connection.persistence.EmployeeDAO;
import dio.mysql.connection.persistence.entity.EmployeeEntity;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {
    private final static EmployeeDAO employeeDAO = new EmployeeDAO();

    public static void main(String[] args) {
        var flyway = Flyway.configure().dataSource("jdbc:mysql://localhost/jdbc_sample", "root", "1234").load();
        flyway.migrate();

        var employee = new EmployeeEntity();
        employee.setName("Matheus");
        employee.setSalary(new BigDecimal("4900"));
        employee.setBirthday(OffsetDateTime.now().minusYears(20));
        System.out.println(employee);
        employeeDAO.insert(employee);
        System.out.println(employee);

        employeeDAO.findAll().forEach(System.out::println);
        System.out.println("============================");
        System.out.println(employeeDAO.findById(2));

        employee.setName("Matheus");
        employee.setSalary(new BigDecimal("7000"));
        employee.setBirthday(OffsetDateTime.now().minusYears(20));
        System.out.println(employee);
        employeeDAO.update(employee);
        System.out.println(employee);

        employeeDAO.delete(employee.getId());
    }
}
