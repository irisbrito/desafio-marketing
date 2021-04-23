package com.br.zup.marketing.exceptions;

public class CategoriaNaoEncontradaException extends RuntimeException{
    private int Status = 400;
    private String campo = "nome";
    private String razaoDoErro = "Bad request";
    private String tipoDoErro = "Categoria não cadastrada";

    public CategoriaNaoEncontradaException(String message) {
        super(message);
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getRazaoDoErro() {
        return razaoDoErro;
    }

    public void setRazaoDoErro(String razaoDoErro) {
        this.razaoDoErro = razaoDoErro;
    }

    public String getTipoDoErro() {
        return tipoDoErro;
    }

    public void setTipoDoErro(String tipoDoErro) {
        this.tipoDoErro = tipoDoErro;
    }
}
