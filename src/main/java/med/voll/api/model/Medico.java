package med.voll.api.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.EnderecoDTO;
import med.voll.api.dto.MedicoDTO;

@Entity
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome, email, crm, telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private EnderecoDTO enderecoDTO;

    public Medico(MedicoDTO medicoDTO) {
        this.nome = medicoDTO.nome();
        this.email = medicoDTO.email();
        this.crm = medicoDTO.crm();
        this.especialidade = medicoDTO.especialidade();
        this.enderecoDTO = medicoDTO.endereco();
        this.telefone = medicoDTO.telefone();
    }
}
