package br.com.zup.handora.muitosparamuitos2.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.muitosparamuitos2.models.Zupper;
import br.com.zup.handora.muitosparamuitos2.models.ZupperDTO;
import br.com.zup.handora.muitosparamuitos2.repositories.ZupperRepository;

@RestController
@RequestMapping(ZupperController.BASE_URI)
public class ZupperController {

    public final static String BASE_URI = "/zuppers";

    private final ZupperRepository zupperRepository;

    public ZupperController(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ZupperDTO zupperDTO,
                                       UriComponentsBuilder ucb) {
        Zupper zupper = zupperRepository.save(zupperDTO.toModel());

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(zupper.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
