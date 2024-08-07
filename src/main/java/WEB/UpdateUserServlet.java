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

@WebServlet("/UserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        User obj = new User();
       String name =req.getParameter("name");
       String email=req.getParameter("email");
       String country=req.getParameter("country");
       int id= Integer.parseInt(req.getParameter("id"));
       obj.setName(name);
       obj.setEmail(email);
       obj.setCountry(country);
       obj.setId(id);
       int result= userDao.updateUser(obj);
       PrintWriter out = resp.getWriter();
       if(result!=0){
           out.println("<h2 style='color:green;'>Updated Successfully!</h2>");
           out.print("<a href='viewServlet'>back</a>");
       }
       else {
           out.println("<h2 style='color:green;'>Updated Failed!</h2>");
           out.print("<a href='viewServlet'>back</a>");
       }

    }
}
