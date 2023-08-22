package med.voll.api.dto.endereco;

public record EnderecoUpdateDTO(
        String logradouro,
        String bairro,
        String cep,
        String numero,
        String complemento,
        String cidade,
        String uf) {
}
