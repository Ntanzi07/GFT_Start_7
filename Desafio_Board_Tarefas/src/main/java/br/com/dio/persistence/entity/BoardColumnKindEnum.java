package br.com.dio.persistence.entity;

import java.util.stream.Stream;

public enum BoardColumnKindEnum {

    INITIAL, FINAL, CANCEL, PEDING;

    public static BoardColumnKindEnum findByName(final String name){
        return Stream.of(BoardColumnKindEnum.values())
                .filter(b -> b.name().equals(name))
                .findFirst().orElseThrow();
    }
}
