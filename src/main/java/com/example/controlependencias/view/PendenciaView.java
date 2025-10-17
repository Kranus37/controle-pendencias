package com.example.controlependencias.view;

import com.example.controlependencias.model.Pendencia;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class PendenciaView {
    private Scanner scanner;

    public PendenciaView() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("\n--- Sistema de Controle de Pendências ---");
        System.out.println("1. Adicionar Pendência");
        System.out.println("2. Listar Pendências");
        System.out.println("3. Atualizar Pendência");
        System.out.println("4. Deletar Pendência");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next();
            System.out.print("Escolha uma opção: ");
        }
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public Pendencia getDadosNovaPendencia() {
        System.out.println("\n--- Adicionar Nova Pendência ---");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        LocalDate dataCriacao = null;
        boolean dataValida = false;
        while (!dataValida) {
            System.out.print("Data de Criação (AAAA-MM-DD): ");
            String dataCriacaoStr = scanner.nextLine();
            try {
                dataCriacao = LocalDate.parse(dataCriacaoStr);
                dataValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use AAAA-MM-DD.");
            }
        }

        System.out.print("Status (Pendente, Em Andamento, Concluída): ");
        String status = scanner.nextLine();

        System.out.print("Prioridade (Baixa, Média, Alta): ");
        String prioridade = scanner.nextLine();

        return new Pendencia(descricao, dataCriacao, status, prioridade);
    }

    public int getPendenciaIdParaAtualizarOuDeletar() {
        System.out.print("Digite o ID da pendência: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next();
            System.out.print("Digite o ID da pendência: ");
        }
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public Pendencia getDadosAtualizacaoPendencia(Pendencia pendenciaExistente) {
        System.out.println("\n--- Atualizar Pendência (ID: " + pendenciaExistente.getId() + ") ---");
        System.out.println("Descrição atual: " + pendenciaExistente.getDescricao());
        System.out.print("Nova Descrição (deixe em branco para manter a atual): ");
        String descricao = scanner.nextLine();
        if (!descricao.isEmpty()) {
            pendenciaExistente.setDescricao(descricao);
        }

        System.out.println("Data de Criação atual: " + pendenciaExistente.getDataCriacao());
        LocalDate dataCriacao = null;
        boolean dataValida = false;
        while (!dataValida) {
            System.out.print("Nova Data de Criação (AAAA-MM-DD, deixe em branco para manter a atual): ");
            String dataCriacaoStr = scanner.nextLine();
            if (dataCriacaoStr.isEmpty()) {
                dataValida = true;
            } else {
                try {
                    dataCriacao = LocalDate.parse(dataCriacaoStr);
                    pendenciaExistente.setDataCriacao(dataCriacao);
                    dataValida = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Use AAAA-MM-DD.");
                }
            }
        }

        System.out.println("Data de Conclusão atual: " + (pendenciaExistente.getDataConclusao() != null ? pendenciaExistente.getDataConclusao() : "N/A"));
        LocalDate dataConclusao = null;
        dataValida = false;
        while (!dataValida) {
            System.out.print("Nova Data de Conclusão (AAAA-MM-DD, deixe em branco para manter a atual, ou digite 'null' para remover): ");
            String dataConclusaoStr = scanner.nextLine();
            if (dataConclusaoStr.isEmpty()) {
                dataValida = true;
            } else if (dataConclusaoStr.equalsIgnoreCase("null")) {
                pendenciaExistente.setDataConclusao(null);
                dataValida = true;
            } else {
                try {
                    dataConclusao = LocalDate.parse(dataConclusaoStr);
                    pendenciaExistente.setDataConclusao(dataConclusao);
                    dataValida = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Use AAAA-MM-DD ou 'null'.");
                }
            }
        }

        System.out.println("Status atual: " + pendenciaExistente.getStatus());
        System.out.print("Novo Status (Pendente, Em Andamento, Concluída, deixe em branco para manter o atual): ");
        String status = scanner.nextLine();
        if (!status.isEmpty()) {
            pendenciaExistente.setStatus(status);
        }

        System.out.println("Prioridade atual: " + pendenciaExistente.getPrioridade());
        System.out.print("Nova Prioridade (Baixa, Média, Alta, deixe em branco para manter a atual): ");
        String prioridade = scanner.nextLine();
        if (!prioridade.isEmpty()) {
            pendenciaExistente.setPrioridade(prioridade);
        }

        return pendenciaExistente;
    }

    public void exibirPendencias(List<Pendencia> pendencias) {
        System.out.println("\n--- Lista de Pendências ---");
        if (pendencias.isEmpty()) {
            System.out.println("Nenhuma pendência encontrada.");
        } else {
            for (Pendencia p : pendencias) {
                System.out.println(p);
            }
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirErro(String erro) {
        System.err.println("ERRO: " + erro);
    }

    public void fecharScanner() {
        scanner.close();
    }
}

