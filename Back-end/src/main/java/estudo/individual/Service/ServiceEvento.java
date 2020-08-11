package estudo.individual.Service;

import estudo.individual.Model.Convidado;
import estudo.individual.Model.Evento;
import estudo.individual.Repository.RepositoryConvidado;
import estudo.individual.Repository.RepositoryEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ServiceEvento {

    @Autowired
    RepositoryEvento repositoryEvento;
    @Autowired
    RepositoryConvidado repositoryConvidado;

    public List<Evento> listarEventos(){
        return repositoryEvento.findAll();
    }

    public Evento mostrarEvento(Integer id, Convidado convidado){
        Evento ev =  repositoryEvento.findOne(id);
        convidado.setEvento(ev);
        return ev;
    }

    public void salvarEvento(Evento evento){
        repositoryEvento.save(evento);
    }

    public void excluirEvento( Evento evento){
        repositoryEvento.delete(evento);
    }
    public void atualizarEvento(Evento evento){
            repositoryEvento.save(evento);
    }
    public List<Evento> filtroNome(@RequestParam("nomepesquisa") String nomepesquisa){
        return repositoryEvento.findByNomeIgnoreCase(nomepesquisa);

    }

}



