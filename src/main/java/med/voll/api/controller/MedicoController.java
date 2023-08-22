package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.ListagemMedicosDTO;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.useful.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ListagemMedicosDTO> getMedicos(){
        return medicoRepository.findAll().stream().map(ListagemMedicosDTO::new).toList();
    }

}
