package estudo.individual.Repository;

import estudo.individual.Model.Evento;
import estudo.individual.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.Path;
import java.util.List;

@Repository
public interface RepositoryEvento extends JpaRepository<Evento, Integer > {

    List<Evento> findEventoByUsuario(Usuario usuario);


@Query("select  e from Evento e WHERE lower(e.nome) LIKE %:nome%")
List<Evento> findByNomeIgnoreCase(@Param("nome") String nome);

@Query(value = "select e from Evento e where lower(e.nome) LIKE %:nome% and e.usuario = :usuario")
List<Evento> findEventoByNomeIgnoreCaseaAndUsuarioId(@Param("nome") String nome, @Param("usuario") Usuario usuario);


@Query("select e from Evento e order by e.datae asc ")
    List<Evento> findAllByOrderByNomeAsc();

@Query("select distinct e from Evento e where e.usuario = :usuario ")
    List<Evento> findEventoByUsuariodistinct(@Param("usuario") Usuario usuario);
};
