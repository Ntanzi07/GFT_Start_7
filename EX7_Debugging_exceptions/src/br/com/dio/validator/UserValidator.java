package br.com.dio.validator;

import br.com.dio.exceptions.ValidatorException;
import br.com.dio.model.UserModel;

public class UserValidator {

    private UserValidator() {

    }

    public static UserModel verifyModel(final UserModel model) throws ValidatorException {
        if (stringIsBlank(model.getName()))
            throw new ValidatorException("Informe um nome Valido");
        if (model.getName().length() <= 1)
            throw new ValidatorException("O nome deve ser maior do que 1");
        if ((stringIsBlank(model.getEmail())) || (!model.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.(com|com\\.br|br|net|org)$")))
            throw new ValidatorException("Informe um Email valido!!");
        
        return model;
    }

    private static boolean stringIsBlank(final String value) {
        return value == null || value.isBlank();
    }
}
