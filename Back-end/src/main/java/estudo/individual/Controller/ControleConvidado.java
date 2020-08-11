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
public class ControleConvidado {
    @Autowired
    ServiceConvidado serviceConvidado;
    @Autowired
    ServiceEvento serviceEvento;


    @GetMapping(value = "/convidados/{id}")
    public List<Convidado> listarConvidados(@PathVariable("id") Integer id){
        return serviceConvidado.listarConvidados(id);
    }

    @PostMapping(value = "/cadastrarconvidado/{id}")
    public void cadastrarConvidado(@RequestBody Convidado convidado, @PathVariable("id") Integer id){
        serviceConvidado.salvarConvidado(id,convidado);
    }
    @DeleteMapping(value = "/excluirconvidado")
    public void excluirConvidado(@RequestBody Convidado convidado){
        serviceConvidado.excluirConvidado(convidado);
    }
    @PutMapping(value = "/atualizarconvidado")
    public void atualizarConvidado(@RequestBody Convidado convidado){
        serviceConvidado.atualizarConvidado(convidado);

    }
    @GetMapping(value = "/pesquisarconvidado")
    public List<Convidado> pesquisarConvidado(@RequestParam("nomepesquisa") String nomepesquisa){
        return serviceConvidado.filtroNomeConvidado(nomepesquisa);
    }

}
