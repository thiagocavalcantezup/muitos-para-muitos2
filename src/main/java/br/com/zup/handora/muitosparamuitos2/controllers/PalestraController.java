package br.com.zup.handora.muitosparamuitos2.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.muitosparamuitos2.models.Palestra;
import br.com.zup.handora.muitosparamuitos2.models.PalestraDTO;
import br.com.zup.handora.muitosparamuitos2.repositories.PalestraRepository;
import br.com.zup.handora.muitosparamuitos2.repositories.ZupperRepository;

@RestController
@RequestMapping(PalestraController.BASE_URI)
public class PalestraController {

    public final static String BASE_URI = "/palestras";

    private final ZupperRepository zupperRepository;
    private final PalestraRepository palestraRepository;

    public PalestraController(ZupperRepository zupperRepository,
                              PalestraRepository palestraRepository) {
        this.zupperRepository = zupperRepository;
        this.palestraRepository = palestraRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid PalestraDTO palestraDTO,
                                       UriComponentsBuilder ucb) {
        Palestra palestra = palestraRepository.save(palestraDTO.toModel(zupperRepository));

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(palestra.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
