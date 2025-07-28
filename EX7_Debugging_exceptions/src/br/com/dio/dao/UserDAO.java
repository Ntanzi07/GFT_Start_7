package br.com.dio.dao;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import br.com.dio.exceptions.EmptyStorageException;
import br.com.dio.exceptions.UserNotFoundException;
import br.com.dio.model.UserModel;

public class UserDAO {
    private final Set<UserModel> models = new LinkedHashSet<>();

    public UserModel save(final UserModel model) {
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model) {
        models.remove(findById(model.getId()));
        return save(model);
    }

    public void delete(final String id) {
        models.remove(findById(id));
    }

    public UserModel findById(final String id) {
        verifyStorage();
        return models.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    var message = String.format("Nao existe usuario com id %s cadastrado", id);
                    throw new UserNotFoundException(message);
                });

    }

    public Set<UserModel> findAll() {
        try {
            verifyStorage();
        } catch (EmptyStorageException ex) {
            System.out.println("O Armazem essta vazio!!!");
        }
        return models;
    }

    private void verifyStorage() {
        if (models.isEmpty())
            throw new EmptyStorageException("No Storege");
    }
}
