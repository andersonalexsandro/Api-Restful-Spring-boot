package med.voll.api.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.medico.MedicoDTO;
import med.voll.api.dto.medico.MedicoUpdateDTO;

@Entity
@Table(name = "medicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome, email, crm, telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO medicoDTO) {
        this.ativo = true;
        this.nome = medicoDTO.nome();
        this.email = medicoDTO.email();
        this.crm = medicoDTO.crm();
        this.especialidade = medicoDTO.especialidade();
        this.endereco = new Endereco(medicoDTO.endereco());
        this.telefone = medicoDTO.telefone();
    }

    public void update(MedicoUpdateDTO medicoUpdateDTO){
        if(medicoUpdateDTO.nome() != null) setNome(medicoUpdateDTO.nome());
        if(medicoUpdateDTO.telefone() != null) setTelefone(medicoUpdateDTO.telefone());
        if(medicoUpdateDTO.especialidade() != null) setEspecialidade(medicoUpdateDTO.especialidade());
        if(medicoUpdateDTO.crm() != null) setCrm(medicoUpdateDTO.crm());
        if(medicoUpdateDTO.email() != null) setEmail(medicoUpdateDTO.email());
        if(medicoUpdateDTO.endereco() != null) this.endereco.update(medicoUpdateDTO.endereco());
    }

    public void excluir() {
        setAtivo(false);
    }
}
