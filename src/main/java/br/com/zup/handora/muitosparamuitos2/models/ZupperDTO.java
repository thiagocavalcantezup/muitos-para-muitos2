package br.com.zup.handora.muitosparamuitos2.models;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

public class ZupperDTO {

    @NotBlank
    private String nome;

    @NotNull
    @PastOrPresent
    private LocalDate dataAdmissao;

    @NotBlank
    @Email
    private String email;

    public ZupperDTO() {}

    public ZupperDTO(@NotBlank String nome, @NotNull @PastOrPresent LocalDate dataAdmissao,
                     @NotBlank @Email String email) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public String getEmail() {
        return email;
    }

}
