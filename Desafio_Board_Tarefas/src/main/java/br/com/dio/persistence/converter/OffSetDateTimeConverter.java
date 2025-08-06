package br.com.dio.persistence.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

import static java.time.ZoneOffset.UTC;
import static java.util.Objects.nonNull;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class OffSetDateTimeConverter {

    public static OffsetDateTime toOffSetDateTime(final Timestamp value){
        return nonNull(value) ? OffsetDateTime.ofInstant(value.toInstant(), UTC) : null;
    }
}
