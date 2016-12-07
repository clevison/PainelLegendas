package servlet;

import bo.UserBO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "register", urlPatterns = "/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 
            String nick = request.getParameter("nick");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
             UserBO userBO = new UserBO();
             
            if (userBO.validateInput(nick, email, password)) {
                if (userBO.validatePassword(password)) {
                    if (userBO.validateNickname(nick)) {
                        if (userBO.validateEmail(email)) {
                            
                                if(userBO.insertUser(nick, email, password)){
                                    response.sendRedirect(request.getContextPath()+"/pages/main.jsp");
                                }else{
                                 RequestDispatcher rs = request.getRequestDispatcher("/pages/error.jsp?message=Ocorreu um erro inesperado&cause=Tente novamente mais tarde. Se o erro persistir Contate um administrador pelo email suporte@painellegendas.com");
				 rs.forward(request, response);
                            }
                        }else{
                            response.sendRedirect(request.getContextPath()+"/pages/register.jsp?message=Email invalido !&cause=Email ja cadastrado");
                        }
                    }else{
                       response.sendRedirect(request.getContextPath()+"/pages/register.jsp?message=Nickname invalido !&cause=Nickname ja cadastrado");
                    }
                }else{
                    response.sendRedirect(request.getContextPath()+"/pages/register.jsp?message=Senha invalida !&cause=Pelo menos 4 digitos, letras maiusculas e minusculas e numeros");
                }
            }else{
                response.sendRedirect(request.getContextPath()+"/pages/register.jsp?message=Dados invalidos !&cause=Os Dados nao podem ser vazios");
            }
	}
}