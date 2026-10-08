package br.com.projeto.dao;

import br.com.projeto.config.Database;
import br.com.projeto.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean cadastrar(Usuario usuario) {

        String sql = """
                INSERT INTO usuario
                (login, senha,perfil) VALUES(???)
                """;
        String senhaHash = BCrypt.hashpw(usuario.getSenha(),
                BCrypt.gensalt(12));

        try (Connection conexao = Database.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {


            stmt.setInt
                    (1, usuario.getId());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, senhaHash); // Ou usuario.getSenha() se não estiver usando hash
            stmt.setBoolean(4, usuario.isStatus());
            stmt.setString(5, usuario.getPerfil());

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

                Usuario usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getBoolean("status"),
                        rs.getString("perfil")
                );
                return usuario;
            }

        } catch (SQLException e) {

            System.out.println("ERRO AO FAZER LOGIN:");
            e.printStackTrace();
        }

        return null;
    }
}