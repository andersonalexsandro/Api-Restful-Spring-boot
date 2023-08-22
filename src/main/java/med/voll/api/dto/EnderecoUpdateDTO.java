package med.voll.api.dto;

public record EnderecoUpdateDTO(
        String logradouro,
        String bairro,
        String cep,
        String numero,
        String complemento,
        String cidade,
        String uf) {
}
