package br.com.fernandogontijo.dao;

import br.com.fernandogontijo.model.Tarefa;
import br.com.fernandogontijo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findAll();
}
