package br.com.dio.persistence.entity;

import lombok.Data;

import static br.com.dio.persistence.entity.BoardColumnKindEnum.INITIAL;

@Data
public class CardEntity {

    private Long id;
    private String title;
    private String description;
    private BoardColumnEntity boardColumn = new BoardColumnEntity();


}
