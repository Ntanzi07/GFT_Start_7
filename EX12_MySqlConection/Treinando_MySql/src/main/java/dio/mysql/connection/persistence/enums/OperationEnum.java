package dio.mysql.connection.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

public enum OperationEnum {
    INSERT,
    UPDATE,
    DELETE;


    public static OperationEnum getByDbOpetarion(final String dbOperation){
        return Stream.of(OperationEnum.values())
                .filter(p -> p.name().startsWith(dbOperation.toUpperCase()))
                .findFirst()
                .orElseThrow();
    }
}
