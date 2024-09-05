package br.com.cadTarefa.controller;


import br.com.cadTarefa.model.Tarefa;
import br.com.cadTarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@RestController// é uma anotação de nível de classe que define o prefixo de URL para todas as rotas de um controller.
@RequestMapping("/tarefa")
public class TarefaController implements Serializable {

    @Autowired
    private TarefaService tarefaService;


    @CrossOrigin
    @PostMapping
    public ResponseEntity<Tarefa> cadTarefa(@RequestBody Tarefa tarefa){
        return ResponseEntity.ok().body(tarefaService.cadTarefa(tarefa));
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Page<Tarefa>> listarTarefa(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)
                                                         Pageable paginacao){
        return ResponseEntity.ok().body(tarefaService.listarTarefa(paginacao));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
         tarefaService.deletar(id);
    }

    @CrossOrigin
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Optional<Tarefa>> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa){
        Optional<Tarefa> taf = tarefaService.atualizar(id, tarefa);
        return ResponseEntity.ok().body(taf);
    }


}
