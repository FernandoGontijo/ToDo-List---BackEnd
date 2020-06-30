package br.com.fernandogontijo.rest;

import br.com.fernandogontijo.dto.TarefaDTO;
import br.com.fernandogontijo.dto.UsuarioDTO;
import br.com.fernandogontijo.model.Tarefa;
import br.com.fernandogontijo.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/tarefa"})
public class TarefaRest {


    @Autowired
    private TarefaService tarefaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TarefaDTO>> findAll(){
        List<Tarefa> tarefas = tarefaService.findAll();
        List<TarefaDTO> listDTO = tarefas.stream().map(e -> new TarefaDTO(e)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }




}
