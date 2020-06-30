package br.com.fernandogontijo.service;

import br.com.fernandogontijo.dao.UsuarioRepository;
import br.com.fernandogontijo.dto.UsuarioDTO;
import br.com.fernandogontijo.model.Usuario;
import br.com.fernandogontijo.service.exceptions.DataIntegrityException;
import br.com.fernandogontijo.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository userRepo;



    public Usuario fromDTO(UsuarioDTO usuarioDTO){

        return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getLogin(), usuarioDTO.getSenha(), usuarioDTO.getEmail());

    }


    public Usuario insert(Usuario usuario){
        usuario.setId(null);
        return userRepo.save(usuario);
    }


    public List<Usuario> findAll(){
        return userRepo.findAll();
    }


    public Usuario find(Long id) {

        Optional<Usuario> user = userRepo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }


    public Usuario update(Usuario user) {
        find(user.getId());
        return userRepo.save(user);
    }


    public void delete(Long id){
        find(id);
        try{
            userRepo.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não foi possível excluir este usuário!");
        }
    }

}















