package br.com.fernandogontijo.rest;


import br.com.fernandogontijo.dto.UsuarioDTO;
import br.com.fernandogontijo.model.Usuario;
import br.com.fernandogontijo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/cadastro"})
public class UsuarioRest {


    @Autowired
    private UsuarioService usuarioService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> list = usuarioService.findAll();
        List<UsuarioDTO> listDTO = list.stream().map(e -> new UsuarioDTO(e)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> find(@PathVariable Long id){
        Usuario user = usuarioService.find(id);
        return ResponseEntity.ok().body(user);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioService.fromDTO(usuarioDTO);
        usuario = usuarioService.insert(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "{/id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "{/id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO userDTO, @PathVariable Long id){
        Usuario user =usuarioService.fromDTO(userDTO);
        user.setId(id);
        user = usuarioService.update(user);
        return ResponseEntity.noContent().build();
    }

}
