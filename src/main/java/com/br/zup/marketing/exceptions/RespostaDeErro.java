package com.br.zup.marketing.exceptions;

import java.util.List;

public class RespostaDeErro {
    private String tipoDeErro;
    private int codigo;
    private String statusCode;
    private List<ObjetoDeErro> objetosDeErro;

    public RespostaDeErro() {
    }

    public RespostaDeErro(String tipoDeErro, int codigo, String statusCode, List<ObjetoDeErro> objetosDeErro) {
        this.tipoDeErro = tipoDeErro;
        this.codigo = codigo;
        this.statusCode = statusCode;
        this.objetosDeErro = objetosDeErro;
    }

    public String getTipoDeErro() {
        return tipoDeErro;
    }

    public void setTipoDeErro(String tipoDeErro) {
        this.tipoDeErro = tipoDeErro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<ObjetoDeErro> getObjetosDeErro() {
        return objetosDeErro;
    }

    public void setObjetosDeErro(List<ObjetoDeErro> objetosDeErro) {
        this.objetosDeErro = objetosDeErro;
    }

}
