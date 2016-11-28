package servlet;

import bo.UserBO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;


@WebServlet(name = "login", urlPatterns = "/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
			 
		 UserBO userBo = new UserBO();
                 User user = userBo.login(nick, password);
                if(user != null) {
                    session.setAttribute("user", user);
                    response.sendRedirect(request.getContextPath()+"/pages/main.jsp");
                } else {
                   response.sendRedirect(request.getContextPath()+"/pages/login.jsp?message=Login invalido !&cause=Usuario ou senha incorretos");
                }
	}
}
