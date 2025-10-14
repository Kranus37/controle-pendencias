package com.example.controlependencias.model;

import java.time.LocalDate;

public class Pendencia {
    private int id;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;
    private String status;
    private String prioridade;

    public Pendencia(int id, String descricao, LocalDate dataCriacao, LocalDate dataConclusao, String status, String prioridade) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataConclusao = dataConclusao;
        this.status = status;
        this.prioridade = prioridade;
    }

    public Pendencia(String descricao, LocalDate dataCriacao, String status, String prioridade) {
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.prioridade = prioridade;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Descrição: '" + descricao + '\'' +
               ", Data Criação: " + dataCriacao +
               ", Data Conclusão: " + (dataConclusao != null ? dataConclusao : "N/A") +
               ", Status: '" + status + '\'' +
               ", Prioridade: '" + prioridade + '\'';
    }
}

