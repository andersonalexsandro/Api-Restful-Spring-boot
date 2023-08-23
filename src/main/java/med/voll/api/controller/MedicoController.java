package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.dto.medico.ListagemMedicosDTO;
import med.voll.api.domain.dto.medico.MedicoDTO;
import med.voll.api.domain.dto.medico.MedicoUpdateDTO;
import med.voll.api.domain.model.Medico;
import med.voll.api.domain.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity save(@RequestBody @Valid MedicoDTO medicoDTO, UriComponentsBuilder builder){
        Medico medico = medicoRepository.save(new Medico(medicoDTO));
        URI uri = UriComponentsBuilder.fromPath("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemMedicosDTO>> getList(@PageableDefault(size = 10, sort = {"nome"}) Pageable page){
        Page<ListagemMedicosDTO> search = medicoRepository.findAllByAtivoTrue(page).map(ListagemMedicosDTO::new);
        return ResponseEntity.ok(search);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new MedicoDTO(medico));
    }

    @Transactional
    @PutMapping
    public ResponseEntity update(@RequestBody @Valid MedicoUpdateDTO medicoDTO){
        Medico medico = medicoRepository.getReferenceById(medicoDTO.id());
        medico.update(medicoDTO);
        return ResponseEntity.ok(new MedicoDTO(medico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @DeleteMapping("/definitive/{id}")
    public ResponseEntity definitiveDelete(@PathVariable Long id){
        medicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
