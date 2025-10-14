package com.example.controlependencias.controller;

import com.example.controlependencias.dao.PendenciaDAO;
import com.example.controlependencias.model.Pendencia;
import com.example.controlependencias.view.PendenciaView;

import java.util.List;

public class PendenciaController {
    private PendenciaDAO dao;
    private PendenciaView view;

    public PendenciaController(PendenciaDAO dao, PendenciaView view) {
        this.dao = dao;
        this.view = view;
    }

    public void iniciarAplicacao() {
        int opcao;
        do {
            opcao = view.exibirMenu();
            switch (opcao) {
                case 1:
                    adicionarPendencia();
                    break;
                case 2:
                    listarPendencias();
                    break;
                case 3:
                    atualizarPendencia();
                    break;
                case 4:
                    deletarPendencia();
                    break;
                case 0:
                    view.exibirMensagem("Saindo do sistema. Até mais!");
                    break;
                default:
                    view.exibirErro("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        view.fecharScanner();
    }

    private void adicionarPendencia() {
        Pendencia novaPendencia = view.getDadosNovaPendencia();
        dao.adicionarPendencia(novaPendencia);
        view.exibirMensagem("Pendência adicionada com sucesso! ID: " + novaPendencia.getId());
    }

    private void listarPendencias() {
        List<Pendencia> pendencias = dao.listarPendencias();
        view.exibirPendencias(pendencias);
    }

    private void atualizarPendencia() {
        int id = view.getPendenciaIdParaAtualizarOuDeletar();
        Pendencia pendenciaExistente = dao.buscarPendenciaPorId(id);

        if (pendenciaExistente != null) {
            Pendencia pendenciaAtualizada = view.getDadosAtualizacaoPendencia(pendenciaExistente);
            dao.atualizarPendencia(pendenciaAtualizada);
            view.exibirMensagem("Pendência atualizada com sucesso!");
        } else {
            view.exibirErro("Pendência com ID " + id + " não encontrada.");
        }
    }

    private void deletarPendencia() {
        int id = view.getPendenciaIdParaAtualizarOuDeletar();
        Pendencia pendenciaExistente = dao.buscarPendenciaPorId(id);

        if (pendenciaExistente != null) {
            dao.deletarPendencia(id);
            view.exibirMensagem("Pendência deletada com sucesso!");
        } else {
            view.exibirErro("Pendência com ID " + id + " não encontrada.");
        }
    }
}

