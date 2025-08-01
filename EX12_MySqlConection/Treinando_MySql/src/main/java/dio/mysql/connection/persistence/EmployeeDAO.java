package dio.mysql.connection.persistence;

import com.mysql.cj.jdbc.StatementImpl;
import dio.mysql.connection.persistence.entity.EmployeeEntity;

import java.beans.Statement;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class EmployeeDAO {

    public void insert(final EmployeeEntity entity) {
        try (
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            var sql = "INSERT INTO employees (name, salary, birthday) values ('" +
                    entity.getName() + "', " +
                    entity.getSalary().toString() + ", " +
                    "'" + formatOffSetDateTime(entity.getBirthday()) + "' )";
            statement.executeUpdate(sql);
            System.out.printf("foram afetados %s registro na base de dados", statement.getUpdateCount());

            if (statement instanceof StatementImpl impl) {
                entity.setId(impl.getLastInsertID());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity) {
        try (
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            var sql = "UPDATE employees set " +
                    "name = '" + entity.getName() + "', " +
                    "salary = " + entity.getSalary().toString() + ", " +
                    "birthday = '" + formatOffSetDateTime(entity.getBirthday()) + "' " +
                    "WHERE id = " + entity.getId();
            statement.executeUpdate(sql);

            System.out.printf("foram afetados %s registro na base de dados", statement.getUpdateCount());

            if (statement instanceof StatementImpl impl) {
                entity.setId(impl.getLastInsertID());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(final long id) {
        try (
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            var sql = "DELETE FROM employees WHERE id = " + id;
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<EmployeeEntity> findAll() {

        List<EmployeeEntity> entities = new ArrayList<>();
        try (
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            statement.executeQuery("SELECT * FROM employees");
            var resultSet = statement.getResultSet();
            while (resultSet.next()) {
                var entity = new EmployeeEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                entities.add(entity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entities;
    }

    public EmployeeEntity findById(final long id) {
        var entity = new EmployeeEntity();
        try (
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            statement.executeQuery("SELECT * FROM employees WHERE id = " + id);
            var resultSet = statement.getResultSet();
            if (resultSet.next()) {
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entity;
    }

    private String formatOffSetDateTime(final OffsetDateTime dateTime) {
        var utcDateTime = dateTime.withOffsetSameInstant(UTC);
        return utcDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
