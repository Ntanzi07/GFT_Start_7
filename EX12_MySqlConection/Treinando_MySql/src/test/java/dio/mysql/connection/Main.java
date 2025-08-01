package dio.mysql.connection;

import dio.mysql.connection.persistence.ConnectionUtil;
import dio.mysql.connection.persistence.EmployeeDAO;
import org.flywaydb.core.Flyway;

import java.sql.SQLException;

public class Main {
    private final static EmployeeDAO employeeDAO = new EmployeeDAO();

    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/jdbc_sample","root","1234")
                .load();
        flyway.migrate();
    }
}
