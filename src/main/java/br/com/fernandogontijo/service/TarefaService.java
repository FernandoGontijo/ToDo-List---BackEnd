package br.com.fernandogontijo.service;


import br.com.fernandogontijo.dao.TarefaRepository;
import br.com.fernandogontijo.dto.TarefaDTO;
import br.com.fernandogontijo.model.Tarefa;
import br.com.fernandogontijo.service.exceptions.DataIntegrityException;
import br.com.fernandogontijo.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepo;


    public Tarefa fromDTO(TarefaDTO tarefaDTO){
        return new Tarefa(tarefaDTO.getId(), tarefaDTO.getNome(),tarefaDTO.getDescricao(), tarefaDTO.getData(), tarefaDTO.getHora());
    }

    public List<Tarefa> findAll(){
        return tarefaRepo.findAll();
    }

    public Tarefa insert(Tarefa tarefa){
        tarefa.setId(null);
        return tarefaRepo.save(tarefa);
    }

    public Tarefa find(Long id) {
        Optional<Tarefa> tarefa = tarefaRepo.findById(id);
        return tarefa.orElseThrow(() -> new ObjectNotFoundException("tarefa não encontrada!"));
    }

    public Tarefa update(Tarefa tarefa){
        find(tarefa.getId());
        return tarefaRepo.save(tarefa);
    }

    public void delete(Long id){
        find(id);
        try{
            tarefaRepo.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não foi possível excluir esta tarefa!");
        }
    }

}
