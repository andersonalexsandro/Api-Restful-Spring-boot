package med.voll.api.dto.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.endereco.EnderecoUpdateDTO;
import med.voll.api.model.Especialidade;

public record MedicoUpdateDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String crm,
        String email,
        Especialidade especialidade,
        EnderecoUpdateDTO endereco) {
}
