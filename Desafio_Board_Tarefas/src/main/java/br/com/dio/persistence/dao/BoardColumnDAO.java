package br.com.dio.persistence.dao;

import br.com.dio.dto.BoardColumnDTO;
import br.com.dio.persistence.entity.BoardColumnEntity;
import br.com.dio.persistence.entity.BoardColumnKindEnum;
import br.com.dio.persistence.entity.CardEntity;
import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.dio.persistence.entity.BoardColumnKindEnum.findByName;
import static java.util.Objects.isNull;


@RequiredArgsConstructor
public class BoardColumnDAO {
    private final Connection connection;

    public BoardColumnEntity insert(final BoardColumnEntity entity) throws SQLException {

        var sql = "INSERT INTO BOARDS_COLUMNS (name, `order`, kind, board_id) VALUES (?, ?, ?, ?);";
        try (var statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            var i = 1;
            statement.setString(i++, entity.getName());
            statement.setInt(i++, entity.getOrder());
            statement.setString(i++, entity.getKind().name());
            statement.setLong(i, entity.getBoard().getId());
            statement.executeUpdate();

            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    var generatedId = rs.getLong(1);
                    entity.setId(generatedId);
                }
            }
            return entity;
        }
    }

    public List<BoardColumnEntity> findByBoardId(Long boardId) throws SQLException {
        List<BoardColumnEntity> entities = new ArrayList<>();
        var sql = "SELECT id, name, `order`, kind FROM BOARDS_COLUMNS WHERE board_id = ? ORDER BY `order`";
        try (var statment = connection.prepareStatement(sql)) {
            statment.setLong(1, boardId);
            statment.executeQuery();
            var resultSet = statment.getResultSet();
            while (resultSet.next()) {
                var entity = new BoardColumnEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setOrder(resultSet.getInt("order"));
                entity.setKind(findByName(resultSet.getString("kind")));
                entities.add(entity);
            }
            return entities;
        }
    }

    public List<BoardColumnDTO> findByBoardIdWithDetails(Long boardId) throws SQLException {
        List<BoardColumnDTO> dtos = new ArrayList<>();
        var sql =
                """
                SELECT  bc.id,
                        bc.name,
                        bc.kind,
                        ( SELECT COUNT(*)
                            FROM CARDS c
                           WHERE c.board_column_id = bc.id
                        ) AS cards_amount
                    FROM BOARDS_COLUMNS bc
                    WHERE board_id = ?
                    ORDER BY `order`
                """;
        try (var statment = connection.prepareStatement(sql)) {
            statment.setLong(1, boardId);
            statment.executeQuery();
            var resultSet = statment.getResultSet();
            while (resultSet.next()) {
                var dto = new BoardColumnDTO(
                        resultSet.getLong("bc.id"),
                        resultSet.getString("bc.name"),
                        findByName(resultSet.getString("bc.kind")),
                        resultSet.getInt("cards_amount")
                );
                dtos.add(dto);
            }
            return dtos;
        }
    }

    public Optional<BoardColumnEntity> findById(Long boardId) throws SQLException {
        List<BoardColumnEntity> entities = new ArrayList<>();
        var sql = """
                  SELECT bc.name, 
                         bc.kind,
                         c.id,
                         c.title,
                         c.description
                    FROM BOARDS_COLUMNS bc
                    LEFT JOIN CARDS c
                      ON c.board_column_id = bc.id
                   WHERE bc.id = ?;
                """;
        try (var statment = connection.prepareStatement(sql)) {
            statment.setLong(1, boardId);
            statment.executeQuery();
            var resultSet = statment.getResultSet();
            if(resultSet.next()){
                var entity = new BoardColumnEntity();
                entity.setName(resultSet.getString("bc.name"));
                entity.setKind(findByName(resultSet.getString("bc.kind")));
                do {
                    if(isNull(resultSet.getString("c.title"))){
                        break;
                    }
                    var card = new CardEntity();
                    card.setId(resultSet.getLong("c.id"));
                    card.setTitle(resultSet.getString("c.title"));
                    card.setDescription(resultSet.getString("c.description"));
                    entity.getCards().add(card);
                } while (resultSet.next());
                return Optional.of(entity);
            }
            return Optional.empty();
        }
    }
}
