package com.br.zup.marketing.exceptions;

public class ObjetoDeErro {
    private String mensagem;
    private String campo;

    public ObjetoDeErro() {
    }

    public ObjetoDeErro(String mensagem, String campoDoErro) {
        this.mensagem = mensagem;
        this.campo = campoDoErro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampoDoErro(String campoDoErro) {
        this.campo = campoDoErro;
    }
}
