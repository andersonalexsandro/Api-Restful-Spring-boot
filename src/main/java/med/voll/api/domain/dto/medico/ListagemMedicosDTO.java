package med.voll.api.domain.dto.medico;

import med.voll.api.domain.model.Especialidade;
import med.voll.api.domain.model.Medico;

public record ListagemMedicosDTO(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade) {

    public ListagemMedicosDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade());
    }

}
