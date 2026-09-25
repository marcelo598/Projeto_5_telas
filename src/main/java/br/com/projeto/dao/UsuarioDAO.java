package br.com.projeto.dao;

import br.com.projeto.config.Database;
import br.com.projeto.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean cadastrar(Usuario usuario) {

        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            System.out.println("Conectado ao banco!");
            System.out.println("Tentando cadastrar: " + usuario.getEmail());

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            int linhas = stmt.executeUpdate();

            System.out.println("Linhas inseridas: " + linhas);

            return linhas > 0;

        } catch (SQLException e) {

            System.out.println("ERRO AO CADASTRAR USUARIO:");
            e.printStackTrace();

            return false;
        }
    }

    public Usuario login(String email, String senha) {

        String sql = "SELECT id, nome, email, senha " +
                "FROM usuarios " +
                "WHERE email = ? AND senha = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));

                return usuario;
            }

        } catch (SQLException e) {

            System.out.println("ERRO AO FAZER LOGIN:");
            e.printStackTrace();
        }

        return null;
    }
}