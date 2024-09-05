package br.com.cadTarefa.service;

import br.com.cadTarefa.model.Tarefa;
import br.com.cadTarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Tarefa> listarTarefa(Pageable pageable) {
        return tarefaRepository.findAll(pageable);
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
