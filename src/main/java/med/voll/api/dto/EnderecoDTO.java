package med.voll.api.dto;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotBlank
        @NotNull
        String logradouro,
        @NotBlank
        @NotNull
        String bairro,
        @NotBlank
        @NotNull
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        @NotNull
        String cidade,
        @NotBlank
        @NotNull
        String uf,
        String complemento,
        String numero) {
}
