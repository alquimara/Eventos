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
public class ServiceConvidado {
    @Autowired
    RepositoryConvidado repositoryConvidado;
    @Autowired
    RepositoryEvento repositoryEvento;

    public List<Convidado> listarConvidados(Integer id){
        Evento ev = repositoryEvento.findOne(id);
          return repositoryConvidado.findConvidadoByEvento(ev);
    }

    public Convidado getConvidado(Integer id){
        return repositoryConvidado.findOne(id);
    }

    public void salvarConvidado(Integer id, Convidado convidado){
        Evento ev =  repositoryEvento.findOne(id);
        convidado.setEvento(ev);
        repositoryConvidado.save(convidado);
    }

    public void excluirConvidado( Convidado convidado){
        repositoryConvidado.delete(convidado);
    }
    public void atualizarConvidado(Convidado convidado){
        repositoryConvidado.save(convidado);
    }
    public List<Convidado> filtroNomeConvidado(@RequestParam("nomepesquisa") String nomepesquisa){
        return repositoryConvidado.findConvidadoByNome(nomepesquisa);

    }
}
