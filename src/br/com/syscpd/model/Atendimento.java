/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syscpd.model;

/**
 *
 * @author teste
 */
public class Atendimento {
    private String iduser;
    private String id_atendimento;
    private String data_atendimento;
    private String loja;
    private String nome;
    private String funcao;
    private String tipo_problema;
    private String sol_problema;
    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(String id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public String getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(String data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTipo_problema() {
        return tipo_problema;
    }

    public void setTipo_problema(String tipo_problema) {
        this.tipo_problema = tipo_problema;
    }

    public String getSol_problema() {
        return sol_problema;
    }

    public void setSol_problema(String sol_problema) {
        this.sol_problema = sol_problema;
    }
}
