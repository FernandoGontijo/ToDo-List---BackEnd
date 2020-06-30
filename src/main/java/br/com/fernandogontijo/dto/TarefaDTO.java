package br.com.fernandogontijo.dto;

import br.com.fernandogontijo.model.Tarefa;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class TarefaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String descricao;
    private Date data;
    private String hora;

    public TarefaDTO(Long id, String nome, String descricao, Date data, String hora) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }

    public TarefaDTO(Tarefa e) {
    }
}
