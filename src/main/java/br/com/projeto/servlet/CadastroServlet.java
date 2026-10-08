package br.com.projeto.servlet;

import br.com.projeto.dao.UsuarioDAO;
import br.com.projeto.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
    private final UsuarioDAO dao = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Pega os parâmetros do formulário com os nomes corretos
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String perfil = request.getParameter("perfil");
        boolean status = true; // Define como ativo por padrão no cadastro

        // 2. Cria o objeto Usuario passando os 5 parâmetros requeridos pelo construtor
        // Passamos 0 no ID pois o banco de dados costuma gerar o ID automaticamente (Auto Increment)
        Usuario usuario = new Usuario(0, login, senha, status, perfil);

        // 3. Executa a inserção no banco
        if (dao.cadastrar(usuario)) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?cadastro=ok");
        } else {
            response.sendRedirect(request.getContextPath() + "/cadastro.jsp?erro=1");
        }
    }
}