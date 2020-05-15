package br.com.tokiomarine.seguradora.avaliacao.entidade;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    private String email;

    private String telefone;

    @NotBlank(message = "Matrícula é obrigatória")
    private String matricula;

    private String curso;

}
