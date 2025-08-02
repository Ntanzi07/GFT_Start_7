package dio.mysql.connection.persistence.entity;

import dio.mysql.connection.persistence.enums.OperationEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record EmployeeAuditEntity(
        long employeeId,
        String name,
        String old_name,
        BigDecimal salary,
        BigDecimal old_salary,
        OffsetDateTime birthday,
        OffsetDateTime old_birthday,
        OperationEnum operation
) {

}
