package WEB;

import MODEL.User;
import USERDAO.userDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/webServlet")
public class webServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              String name= req.getParameter("name");
               String email=req.getParameter("email");
              String country= req.getParameter("country");
              User us = new User();
              us.setName(name);
              us.setEmail(email);
              us.setCountry(country);
              int result =userDao.saveDetails(us);
             resp.setContentType("text/html");

        if(result>0){
                  PrintWriter out = resp.getWriter();
                  out.println("<h2 style='color:green;'>Inserted Successfully!</h2>");
                  out.print("<a href='index.jsp'>back</a>");

        }
              else {
                  PrintWriter out = resp.getWriter();
                  out.println("<h2 style='color:green;'>Inserted Successfully!</h2>");
            out.print("<a href='index.jsp'>back</a>");

        }

             // resp.sendRedirect("index.jsp");
    }
}
