package br.com.cadTarefa.service;

import br.com.cadTarefa.model.Tarefa;
import br.com.cadTarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService  {


    @Autowired
    private TarefaRepository tarefaRepository;

    @Transactional
    public Tarefa cadTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefa() {
        return tarefaRepository.findAll();
    }

    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }

    public Optional<Tarefa> atualizar(Long id, Tarefa tarefa) {
       Optional<Tarefa> taf = tarefaRepository.findById(id);

        taf.get().setTitulo(tarefa.getTitulo());
        taf.get().setDescricao(tarefa.getDescricao());

       return Optional.of(tarefaRepository.save(taf.get()));
    }
}
