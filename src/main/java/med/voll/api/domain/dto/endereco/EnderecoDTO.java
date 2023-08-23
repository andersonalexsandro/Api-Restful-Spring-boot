package med.voll.api.domain.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.model.Endereco;

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
        public EnderecoDTO(Endereco endereco) {
                this(endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(), endereco.getCidade(), endereco.getUf(), endereco.getComplemento(), endereco.getNumero());
        }
}
