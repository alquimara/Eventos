package estudo.individual.Controller;

import estudo.individual.Model.Usuario;
import estudo.individual.Service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ControllerUsuario {
    @Autowired
    ServiceUsuario serviceUsuario;

    @PostMapping(value = "/cadastrarUsuario")
    public void cadastrarUsuario(@RequestBody Usuario usuario){
        serviceUsuario.salvarUsuario(usuario);
    }
    @GetMapping(value = "/usuarios")
    public List<Usuario> listarUsuarios(){
        return serviceUsuario.mostrarUsuarios();

    }
}
