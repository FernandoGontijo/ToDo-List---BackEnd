package br.com.fernandogontijo.dao;

import br.com.fernandogontijo.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByLogin(String login);

    List<Usuario> findAll();

}
