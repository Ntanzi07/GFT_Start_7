package dio.web.api.controller;

import dio.web.api.model.Usuario;
import dio.web.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/{userName}")
    public Usuario getOne(@PathVariable("userName") String userName){
        return repository.findByUserName(userName);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        repository.deleteById(userId);
    }

    @PostMapping
    public void postUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
}
