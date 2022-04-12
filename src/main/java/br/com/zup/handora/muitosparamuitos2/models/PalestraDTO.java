package br.com.zup.handora.muitosparamuitos2.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PalestraDTO {

    @NotBlank
    private String titulo;

    @NotBlank
    private String tema;

    @NotNull
    @Min(30)
    private Integer tempoMinutos;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoPalestra tipo;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHora;

    @NotEmpty
    @Size(min = 1)
    private Set<Long> zupperIds;

    public PalestraDTO() {}

    public PalestraDTO(@NotBlank String titulo, @NotBlank String tema,
                       @NotNull @Min(30) Integer tempoMinutos, @NotNull TipoPalestra tipo,
                       @NotNull @Future LocalDateTime dataHora,
                       @NotEmpty @Size(min = 1) Set<Long> zupperIds) {
        this.titulo = titulo;
        this.tema = tema;
        this.tempoMinutos = tempoMinutos;
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.zupperIds = zupperIds;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTema() {
        return tema;
    }

    public Integer getTempoMinutos() {
        return tempoMinutos;
    }

    public TipoPalestra getTipo() {
        return tipo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Set<Long> getZupperIds() {
        return zupperIds;
    }

}
