package servlet;

import bo.UserBO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;


@WebServlet(name = "edit_profile", urlPatterns = "/edit_profile")
public class edit_profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //Atual user
            User user = (User)request.getSession(false).getAttribute("user");     
           
            String nick = request.getParameter("nick");
            String email = request.getParameter("email");
             UserBO userBO = new UserBO();
             
            if (userBO.validateInput(nick, email)) {
                    //New data
                    User newUser = new User();
                    newUser.setEmail(email);
                    newUser.setNickname(nick);
                    newUser.setPermission(user.getPermission());
                    newUser.setId_User(user.getId_User());
                    
                    System.out.println(userBO.equalData(nick,"nickname", newUser.getId_User()));
                    
                    if (userBO.equalData(nick, "nickname", newUser.getId_User())) {
                        userBO.updateNick(newUser);
                       
                    }else{
                        newUser.setNickname(user.getNickname());
                         newUser.setEmail(user.getEmail());
                        response.sendRedirect(request.getContextPath()+"/pages/edit_profile.jsp?message=Nickname invalido !&cause=Este nickname nao pode ser usado");
                        return;
                    }
                    
                    if (userBO.equalData(email,"email",newUser.getId_User())) {
                        userBO.updateEmail(newUser);
                    }else{
                        newUser.setNickname(user.getNickname());
                        newUser.setEmail(user.getEmail());
                        response.sendRedirect(request.getContextPath()+"/pages/edit_profile.jsp?message=Email invalido !&cause=Este email nao pode ser usado");
                         return;
                    }
                    
                    request.getSession().setAttribute("user", newUser);
                    response.sendRedirect(request.getContextPath()+"/main");
                    
            }else{
                response.sendRedirect(request.getContextPath()+"/pages/edit_profile.jsp?message=Dados invalidos !&cause=Os Dados nao podem ser vazios");
            }
	}
}