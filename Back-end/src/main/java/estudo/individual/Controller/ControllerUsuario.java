package estudo.individual.Controller;

import estudo.individual.Model.Evento;
import estudo.individual.Model.Usuario;
import estudo.individual.Service.ServiceEvento;
import estudo.individual.Service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ControllerUsuario {
    @Autowired
    ServiceUsuario serviceUsuario;

    @PostMapping(value = "/cadastrarUsuario")
    public void cadastrarUsuario(@RequestBody Usuario usuario){
        serviceUsuario.salvarUsuario(usuario);
    }
}
