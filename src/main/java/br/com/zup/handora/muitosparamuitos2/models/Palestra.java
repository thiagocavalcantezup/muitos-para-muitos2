package br.com.zup.handora.muitosparamuitos2.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "palestras")
public class Palestra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String tema;

    @Column(nullable = false)
    @Min(30)
    private Integer tempoMinutos;

    @Column(nullable = false)
    private TipoPalestra tipo;

    @Column(nullable = false)
    @Future
    private LocalDateTime dataHora;

    @Column(nullable = false)
    @Size(min = 1)
    @ManyToMany
    @JoinTable(name = "palestra_zupper", joinColumns = @JoinColumn(name = "palestra_id"), inverseJoinColumns = @JoinColumn(name = "zupper_id"))
    private Set<Zupper> zuppers;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Palestra() {}

    public Palestra(String titulo, String tema, @Min(30) Integer tempoMinutos, TipoPalestra tipo,
                    @Future LocalDateTime dataHora, @Size(min = 1) Set<Zupper> zuppers) {
        this.titulo = titulo;
        this.tema = tema;
        this.tempoMinutos = tempoMinutos;
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.zuppers = zuppers;
    }

    public Long getId() {
        return id;
    }

}
