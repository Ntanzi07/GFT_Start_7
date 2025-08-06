package br.com.dio.ui;

import br.com.dio.dto.BoardColumnInfoDTO;
import br.com.dio.persistence.entity.BoardColumnEntity;
import br.com.dio.persistence.entity.BoardColumnKindEnum;
import br.com.dio.persistence.entity.BoardEntity;
import br.com.dio.persistence.entity.CardEntity;
import br.com.dio.service.BoardColumnQueryService;
import br.com.dio.service.BoardQueryService;
import br.com.dio.service.CardQueryService;
import br.com.dio.service.CardService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Scanner;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;
import static br.com.dio.persistence.entity.BoardColumnKindEnum.INITIAL;

@AllArgsConstructor
public class BoardMenu {
    private final BoardEntity entity;
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public void execute() {
        try{
            var option = -1;
            while (option != 9) {
                System.out.printf("Bem vindo ao board %s\n", entity.getId());
                System.out.println("1 - Criar um card");
                System.out.println("2 - Mover um card");
                System.out.println("3 - Bloquear um card");
                System.out.println("4 - Desbloquear um card");
                System.out.println("5 - Cancelar um card");
                System.out.println("6 - Visualizar board");
                System.out.println("7 - Visualizar coluna com cards");
                System.out.println("8 - Visualizar card");
                System.out.println("9 - Voltar para o menu anterior card");
                System.out.println("10 - Sair");
                System.out.println("Escolha sua opcao: ");
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> createCard();
                    case 2 -> moveCardToNextColumn();
                    case 3 -> blockCard();
                    case 4 -> unblockCard();
                    case 5 -> cancelCard();
                    case 6 -> showBoard();
                    case 7 -> showColumn();
                    case 8 -> showCard();
                    case 9 -> System.out.println("Voltando para o menu anterior");
                    case 10 -> System.exit(0);
                    default -> System.out.println("Essa opcao nao existe!!!");
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            System.exit(0);
        }

    }

    private void createCard() throws SQLException{
        var card = new CardEntity();
        System.out.println("Informe o titulo do card");
        card.setTitle(scanner.next());
        System.out.println("informe a descricao do card");
        card.setDescription(scanner.next());
        card.setBoardColumn(entity.getInitialColumn());
        try(var connection = getConnection()) {
            new CardService(connection).insert(card);
        }
    }

    private void moveCardToNextColumn() throws SQLException {
        System.out.println("informe o id do card que desseja mover para proxima coluna");
        var cardId = scanner.nextLong();
        var boardColumnsInfos = entity.getBoardColumns().stream()
                .map(bc -> new BoardColumnInfoDTO(bc.getId(), bc.getOrder(), bc.getKind()))
                .toList();
        try(var connection = getConnection()){
            new CardService(connection).moveToNextColumn(cardId, boardColumnsInfos);
        }
    }

    private void blockCard() {

    }

    private void unblockCard() {

    }

    private void cancelCard() {

    }

    private void showBoard() throws SQLException {
        try (var connection = getConnection()) {
            var optional = new BoardQueryService(connection).showBoardDetails(entity.getId());
            optional.ifPresent(b-> {
                System.out.printf("Board [%s, %s]\n", b.id(),b.name());
                b.columns().forEach(c -> {
                    System.out.printf("Coluna [%s] tipo: [%s] tem %s cards\n", c.name(),c.kind(),c.cardsAmount());
                });
            });
        }
    }

    private void showColumn() throws SQLException {
        var columnsIds = entity.getBoardColumns().stream().map(BoardColumnEntity::getId).toList();
        var selectedColumn = -1L;
        while (!columnsIds.contains(selectedColumn)){
            System.out.printf("Escolha uma coluna do borad %s\n", entity.getName());
            entity.getBoardColumns().forEach(c -> System.out.printf("%s - %s [%s]\n", c.getId(),c.getName(), c.getKind()));
            selectedColumn = scanner.nextLong();
        }
        try(var connection = getConnection()){
            var column = new BoardColumnQueryService(connection).findById(selectedColumn);
            column.ifPresent(co -> {
                System.out.printf("Coluna %s tipo %s\n", co.getName(), co.getKind());
                co.getCards().forEach(ca -> System.out.printf("Card %s - %s\nDescricao: %s",
                        ca.getId(),ca.getTitle(),ca.getDescription()));
            });
        }
    }

    private void showCard() throws SQLException{
        System.out.println("Informe o id do card que deseja visualizar");
        var selectedCardId = scanner.nextLong();
        try(var connection = getConnection()){
            new CardQueryService(connection).findById(selectedCardId)
                    .ifPresentOrElse(
                            c -> {
                                System.out.printf("Card %s - %s.\n", c.id(), c.title());
                                System.out.printf("Descricao: %s\n", c.description());
                                System.out.println(c.blocked()
                                        ? "Esta bloqueado, Motivo: " + c.blockReason()
                                        : "Nao esta bloqueado");
                                System.out.printf("Ja foi bloqueado %s vezes\n", c.blocksAmounth());
                                System.out.printf("Esta no momento na coluna %s - %s\n",c.columnId(), c.columnName());
                            },
                            () -> System.out.printf("Nao existe um card com o id %s\n", selectedCardId));
        }
    }
}
