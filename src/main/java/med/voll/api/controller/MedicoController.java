package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.ListagemMedicosDTO;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.dto.MedicoUpdateDTO;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.useful.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EntityMapper entityMapper;

    @Transactional
    @PostMapping
    public Medico save(@RequestBody @Valid MedicoDTO medicoDTO){
        Medico medico = new Medico(medicoDTO);
        medicoRepository.save(medico);
        return medico;
    }

    @GetMapping
    public Page<ListagemMedicosDTO> getList(@PageableDefault(size = 10, sort = {"nome"}) Pageable page){
        return medicoRepository.findAll(page).map(ListagemMedicosDTO::new);
    }

    @Transactional
    @PutMapping
    public void update(@RequestBody @Valid MedicoUpdateDTO medicoDTO){
        Medico medico = medicoRepository.getReferenceById(medicoDTO.id());
        medico.update(medicoDTO);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        medicoRepository.deleteById(id);
    }
}
