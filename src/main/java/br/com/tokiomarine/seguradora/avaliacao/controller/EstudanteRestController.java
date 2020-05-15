package br.com.tokiomarine.seguradora.avaliacao.controller;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudanteRestController {

    EstudanteRepository repository;

    EstudanteRestController(EstudanteRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/estudantes/add")
    Estudante adicionarEstudante(@RequestBody Estudante estudante){
        return repository.save(estudante);
    }

    @PutMapping("/estudantes/editar/{id}")
    Estudante exibirEdicaoEstudante(@RequestBody Estudante novoEstudante,
                                    @PathVariable Long id){
        return repository.findById(id)
                .map(estudante -> {
                    estudante.setNome(novoEstudante.getNome());
                    estudante.setEmail(novoEstudante.getEmail());
                    estudante.setTelefone(novoEstudante.getTelefone());
                    return repository.save(estudante);
                })
                .orElseGet(() -> {
                    novoEstudante.setId(id);
                    return repository.save(novoEstudante);
                });
    }

    @GetMapping("/estudantes/listar")
    List<Estudante> listarEstudantes() {
        return (List<Estudante>) repository.findAll();
    }

    @DeleteMapping("/estudantes/apagar/{id}")
    void apagarEstudante(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
