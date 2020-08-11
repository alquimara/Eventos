package estudo.individual.Controller;

import estudo.individual.Model.Convidado;
import estudo.individual.Model.Evento;
import estudo.individual.Service.ServiceConvidado;
import estudo.individual.Service.ServiceEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class ControllerEvento {

    @Autowired
    ServiceEvento serviceEvento;

    @GetMapping(value = "/eventos")
    public List<Evento>listarEventos(){
      return serviceEvento.listarEventos();
    }

    @GetMapping(value = "/eventos/{id}")
    public Evento mostrarEvento(@PathVariable("id") Integer id, Convidado convidado){
        return serviceEvento.mostrarEvento(id, convidado);
    }

    @PostMapping(value = "/cadastrar")
    public void cadastrarEvento(@RequestBody Evento evento){
        serviceEvento.salvarEvento(evento);
    }


    @DeleteMapping(value = "/excluir")
    public void excluirEvento(@RequestBody Evento evento){
        serviceEvento.excluirEvento(evento);

    }

    @PutMapping(value = "/atualizar")
    public void atualizarEvento(@RequestBody Evento evento){
        serviceEvento.atualizarEvento(evento);

    }
    @GetMapping(value = "/pesquisar")
    public List<Evento> pesquisar(@RequestParam("nomepesquisa") String nomepesquisa){
        return serviceEvento.filtroNome(nomepesquisa);
    }

}
