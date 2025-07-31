package dio.web.api.repository;

import dio.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Repository
public class UsuarioRepository {

    public void save(Usuario usuario) {
        if (isNull(usuario.getId())) {
            System.out.println("Salvando user " + usuario);
        } else {
            System.out.println("Atualizando user " + usuario);
        }
    }

    public void deleteById(Integer id) {
        System.out.println("Deletando id: " + id);
    }

    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("nathan", "password"));
        usuarios.add(new Usuario("julia", "123456"));
        return usuarios;
    }

    public Usuario findByUserName(String userName) {
        System.out.println("Aqui seu user:");
        return new Usuario(userName, "123456");
    }

    public Usuario findById(Integer id) {
        System.out.println("Aqui seu user:");
        return new Usuario("nathan", "123456");
    }
}
