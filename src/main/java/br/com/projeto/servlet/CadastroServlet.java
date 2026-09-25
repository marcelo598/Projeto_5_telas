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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario(nome, email, senha);

        if (dao.cadastrar(usuario)) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?cadastro=ok");
        } else {
            response.sendRedirect(request.getContextPath() + "/cadastro.jsp?erro=1");
        }
    }
}
