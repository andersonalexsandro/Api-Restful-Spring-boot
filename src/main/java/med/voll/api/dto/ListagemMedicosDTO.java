package med.voll.api.dto;

import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record ListagemMedicosDTO(String nome, String email, String telefone, String crm, Especialidade especialidade) {

    public ListagemMedicosDTO(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade());
    }

}
