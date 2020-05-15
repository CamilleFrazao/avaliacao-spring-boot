package br.com.tokiomarine.seguradora.avaliacao.controller;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudante")
public class EstudanteRestController {

    EstudanteRepository repository;

    EstudanteRestController(EstudanteRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    Estudante adicionarEstudante(@RequestBody Estudante estudante){
        return repository.save(estudante);
    }

    @PutMapping("/editar/{id}")
    Estudante exibirEdicaoEstudante(@RequestBody Estudante novoEstudante,
                                    @PathVariable Long id){
        return repository.findById(id)
                .map(estudante -> {
                    estudante.setNome(novoEstudante.getNome());
                    estudante.setEmail(novoEstudante.getEmail());
                    estudante.setTelefone(novoEstudante.getTelefone());
                    estudante.setCurso(novoEstudante.getCurso());
                    estudante.setMatricula(novoEstudante.getMatricula());
                    return repository.save(estudante);
                })
                .orElseGet(() -> {
                    novoEstudante.setId(id);
                    return repository.save(novoEstudante);
                });
    }

    @GetMapping("/listar")
    List<Estudante> listarEstudantes() {
        return (List<Estudante>) repository.findAll();
    }

    @DeleteMapping("/apagar/{id}")
    void apagarEstudante(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
