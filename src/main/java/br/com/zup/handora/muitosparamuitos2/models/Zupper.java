package br.com.zup.handora.muitosparamuitos2.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;

@Entity
@Table(name = "zuppers")
public class Zupper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @PastOrPresent
    private LocalDate dataAdmissao;

    @Column(nullable = false)
    @Email
    private String email;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Zupper() {}

    public Zupper(String nome, @PastOrPresent LocalDate dataAdmissao, @Email String email) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

}
