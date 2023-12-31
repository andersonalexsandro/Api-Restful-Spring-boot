package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.dto.usuario.UsuarioDTO;
import med.voll.api.domain.model.Usuario;
import med.voll.api.infra.security.TokenService;
import med.voll.api.infra.security.TokenJWTDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UsuarioDTO usuario){
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuario.login(), usuario.senha());
        var authentication = manager.authenticate(usernamePasswordAuthenticationToken);
        String tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWTDTO(tokenJWT));
    }

}
