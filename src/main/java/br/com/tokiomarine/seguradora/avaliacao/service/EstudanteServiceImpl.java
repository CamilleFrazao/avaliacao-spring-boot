package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudanteServiceImpl implements EstudandeService {

	@Autowired
	EstudanteRepository repository;

	@Override
	public void cadastrarEstudante(Estudante estudante) {
		repository.save(estudante);
	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	@Override
	public List<Estudante> buscarEstudantes() {
		return (List<Estudante>) repository.findAll();
	}

	@Override
	public Estudante buscarEstudante(Long id) {
		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
	}

	@Override
	public void deletarEstudante(Estudante estudante){
		repository.delete(estudante);
	}

}
