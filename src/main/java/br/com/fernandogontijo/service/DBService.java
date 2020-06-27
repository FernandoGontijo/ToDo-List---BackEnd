package br.com.fernandogontijo.service;

import br.com.fernandogontijo.dao.TarefaRepository;
import br.com.fernandogontijo.dao.UsuarioRepository;
import br.com.fernandogontijo.model.Tarefa;
import br.com.fernandogontijo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TarefaRepository tarefaRepository;


    public void instantiateDatabase() throws ParseException {


        Usuario usuario = new Usuario(null, "Fernando Gontijo", "fernando", "Senha@2020", "fernando.gontijos@hotmail.com");
        Usuario usuario2 = new Usuario(null, "Leticia Ribeiro", "leticia", "Senha@2002", "leticiaribeirounai@gmail.com");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");

        Tarefa tarefa = new Tarefa(null, "Dentista", "Dentista sábado", sdf.parse("27/06/2020 08:20"), "08:20", usuario);
        Tarefa tarefa2 = new Tarefa(null, "Formação", "Formação amanha a tarde", sdf.parse("27/06/2020 14:00"), "14:00", usuario);
        Tarefa tarefa3 = new Tarefa(null, "Gravar vídeo", "Gravar vídeo tocando gaita", null, null, usuario);
        Tarefa tarefa4 = new Tarefa(null, "Projeto Juliana", "Terminar de desenvolver o site da Juliana", sdf.parse("04/07/2020 10:00"), "10:00", usuario);
        Tarefa tarefa5 = new Tarefa(null, "Limpar a casa", "Limpa a casa sábado de manhã", null, null, usuario2);
        Tarefa tarefa6 = new Tarefa(null, "Estudar", "Estudar para a semana de prova", null, null, usuario2);
        Tarefa tarefa7 = new Tarefa(null, "Entrega TCC", "Entrega final do TCC", sdf.parse("03/07/2020 20:00"), "20:00", usuario2);


        usuarioRepository.saveAll(Arrays.asList(usuario, usuario2));

        tarefaRepository.saveAll(Arrays.asList(tarefa, tarefa2, tarefa3, tarefa4, tarefa5, tarefa6, tarefa7));


    }
}
