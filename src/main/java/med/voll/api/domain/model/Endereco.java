package med.voll.api.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.domain.dto.endereco.EnderecoDTO;
import med.voll.api.domain.dto.endereco.EnderecoUpdateDTO;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro, bairro, cep, numero, complemento, cidade, uf;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public Endereco update(EnderecoUpdateDTO enderecoUpdateDTO){
        if(enderecoUpdateDTO.logradouro() != null) setLogradouro(enderecoUpdateDTO.logradouro());
        if(enderecoUpdateDTO.bairro() != null) setBairro(enderecoUpdateDTO.bairro());
        if(enderecoUpdateDTO.cep()!= null) setCep(enderecoUpdateDTO.cep());
        if(enderecoUpdateDTO.numero()!= null) setNumero(enderecoUpdateDTO.numero());
        if(enderecoUpdateDTO.complemento()!= null) setComplemento(enderecoUpdateDTO.complemento());
        if(enderecoUpdateDTO.cidade() != null) setCidade(enderecoUpdateDTO.cidade());
        if(enderecoUpdateDTO.uf()!= null) setUf(enderecoUpdateDTO.uf());
        return this;
    }

}
