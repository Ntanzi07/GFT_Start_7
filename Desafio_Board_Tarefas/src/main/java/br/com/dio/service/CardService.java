package br.com.dio.service;

import br.com.dio.dto.BoardColumnInfoDTO;
import br.com.dio.exceptions.CardBlockedException;
import br.com.dio.exceptions.CardFinishedException;
import br.com.dio.exceptions.EntityNotFoundException;
import br.com.dio.persistence.dao.CardDAO;
import br.com.dio.persistence.entity.CardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static br.com.dio.persistence.entity.BoardColumnKindEnum.FINAL;

@AllArgsConstructor
public class CardService {
    private final Connection connection;

    public CardEntity insert(final CardEntity entity) throws SQLException {
        try {
            var dao = new CardDAO(connection);
            dao.insert(entity);
            connection.commit();
            return entity;
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        }
    }

    public void moveToNextColumn(final Long cardId, final List<BoardColumnInfoDTO> boardColumnsInfo) throws SQLException {
        try {
            var dao = new CardDAO(connection);
            var optional = dao.findById(cardId);
            var dto = optional.orElseThrow(
                    () -> new EntityNotFoundException("O card de id %s nao foi encontrado".formatted(cardId))
            );

            if (dto.blocked()) {
                throw new CardBlockedException("O card esta bloqueado. nessesario desbloquear!!!");
            }

            var currentColumn = boardColumnsInfo.stream()
                    .filter(bc -> bc.id().equals(dto.columnId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("O card informado pertence a outro board"));
            if (currentColumn.kind().equals(FINAL)) {
                throw new CardFinishedException("O card ja esta em itens finalizados");
            }
            var nextColumn = boardColumnsInfo.stream()
                    .filter(bc -> bc.order() == currentColumn.order() + 1)
                    .findFirst()
                    .orElseThrow();
            dao.moveToColumn(nextColumn.id(), cardId);
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        }
    }
}
