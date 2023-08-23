package med.voll.api.domain.dto.endereco;

public record EnderecoUpdateDTO(
        String logradouro,
        String bairro,
        String cep,
        String numero,
        String complemento,
        String cidade,
        String uf) {
}
