package com.example.controlependencias.dao;

import com.example.controlependencias.model.Pendencia;
import com.example.controlependencias.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PendenciaDAO {

    public void adicionarPendencia(Pendencia pendencia) {
        String sql = "INSERT INTO pendencias (descricao, data_criacao, status, prioridade) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, pendencia.getDescricao());
            stmt.setDate(2, Date.valueOf(pendencia.getDataCriacao()));
            stmt.setString(3, pendencia.getStatus());
            stmt.setString(4, pendencia.getPrioridade());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pendencia.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar pendência: " + e.getMessage());
        }
    }

    public List<Pendencia> listarPendencias() {
        List<Pendencia> pendencias = new ArrayList<>();
        String sql = "SELECT * FROM pendencias";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pendencia pendencia = new Pendencia(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getDate("data_criacao").toLocalDate(),
                        rs.getDate("data_conclusao") != null ? rs.getDate("data_conclusao").toLocalDate() : null,
                        rs.getString("status"),
                        rs.getString("prioridade")
                );
                pendencias.add(pendencia);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar pendências: " + e.getMessage());
        }
        return pendencias;
    }

    public Pendencia buscarPendenciaPorId(int id) {
        String sql = "SELECT * FROM pendencias WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pendencia(
                            rs.getInt("id"),
                            rs.getString("descricao"),
                            rs.getDate("data_criacao").toLocalDate(),
                            rs.getDate("data_conclusao") != null ? rs.getDate("data_conclusao").toLocalDate() : null,
                            rs.getString("status"),
                            rs.getString("prioridade")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar pendência por ID: " + e.getMessage());
        }
        return null;
    }

    public void atualizarPendencia(Pendencia pendencia) {
        String sql = "UPDATE pendencias SET descricao = ?, data_criacao = ?, data_conclusao = ?, status = ?, prioridade = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pendencia.getDescricao());
            stmt.setDate(2, Date.valueOf(pendencia.getDataCriacao()));
            stmt.setDate(3, pendencia.getDataConclusao() != null ? Date.valueOf(pendencia.getDataConclusao()) : null);
            stmt.setString(4, pendencia.getStatus());
            stmt.setString(5, pendencia.getPrioridade());
            stmt.setInt(6, pendencia.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar pendência: " + e.getMessage());
        }
    }

    public void deletarPendencia(int id) {
        String sql = "DELETE FROM pendencias WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar pendência: " + e.getMessage());
        }
    }
}

