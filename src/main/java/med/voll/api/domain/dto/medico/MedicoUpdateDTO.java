package med.voll.api.domain.dto.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.dto.endereco.EnderecoUpdateDTO;
import med.voll.api.domain.model.Especialidade;

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
