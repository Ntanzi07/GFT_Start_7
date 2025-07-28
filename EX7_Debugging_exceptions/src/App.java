import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.dio.dao.UserDAO;
import br.com.dio.exceptions.EmptyStorageException;
import br.com.dio.exceptions.UserNotFoundException;
import br.com.dio.exceptions.ValidatorException;
import br.com.dio.model.MenuOptions;
import br.com.dio.model.UserModel;
import static br.com.dio.validator.UserValidator.verifyModel;

public class App {
    private final static Scanner scanner = new Scanner(System.in);
    private final static UserDAO dao = new UserDAO();
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) throws Exception {
        MenuOptions selectedOption;
        do {
            System.out.println("");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Buscar por id");
            System.out.println("5 - Listar todos");
            System.out.println("6 - Sair");
            System.out.print("Bem vindo ao cadastro de usuario, selecione a operacao dessejada:");
            selectedOption = MenuOptions.values()[scanner.nextInt() - 1];

            switch (selectedOption) {
                case SAVE -> dao.save(requestToSave());
                case UPDATE -> {
                    try {
                        dao.update(requestToUpdate());
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestID());
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case FIND_BY_ID -> {
                    try {
                        System.out.println(dao.findById(requestID())); 
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case FIND_ALL -> dao.findAll().stream().forEach(System.out::println);
                case EXIT -> System.exit(0);
            }

        } while (true);
    }

    private static UserModel requestToSave() {
        String name, email;
        LocalDate birthday;
        while (true) {
            System.out.println("Informe o nome do usuario:");
            name = scanner.next();
            System.out.println("Informe o email do usuario:");
            email = scanner.next();
            System.out.println("Informe a data de nascimento do usuario (dd/MM/yyyy):");
            birthday = LocalDate.parse(scanner.next(), formatter);

            try {
                return verifyModel(new UserModel(name, email, birthday));
            } catch (ValidatorException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    private static UserModel requestToUpdate() {
        String id, name, email;
        LocalDate birthday;
        while (true) {
            System.out.println("Informe o id do usuario:");
            id = scanner.next();
            System.out.println("Informe o nome do usuario:");
            name = scanner.next();
            System.out.println("Informe o email do usuario:");
            email = scanner.next();
            System.out.println("Informe a data de nascimento do usuario (dd/MM/yyyy):");
            birthday = LocalDate.parse(scanner.next(), formatter);

            try {
                return verifyModel(new UserModel(id, name, email, birthday));
            } catch (ValidatorException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static String requestID() {
        System.out.println("Informe o id do usuario:");
        return scanner.next();
    }

}
