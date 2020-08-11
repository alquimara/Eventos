package estudo.individual.Repository;

import estudo.individual.Model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryEvento extends JpaRepository<Evento, Integer > {
@Query("select  e from Evento e WHERE lower(e.nome) LIKE %:nome%")
List<Evento> findByNomeIgnoreCase(@Param("nome") String nome);
};
