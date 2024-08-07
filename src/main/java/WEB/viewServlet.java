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
import java.util.List;
import USERDAO.*;
@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        userDao ed=new userDao();
        List<User> listEmp=ed.selectUser();

        out.print("<table border=1 width='100%'>");
        out.print("<tr>");
        out.print("<th>ID</th>");
        out.print("<th>NAME</th>");
        out.print("<th>EMAIL</th>");
        out.print("<th>COUNTRY</th>");
        out.print("<th>EDIT</th>");
        out.print("<th>DELETE</th>");
        out.print("</tr>");

        for(User e:listEmp) {
            out.print("<tr>");
            out.print("<td>"+e.getId()+"</td>");
            out.print("<td>"+e.getName()+"</td>");
            out.print("<td>"+e.getEmail()+"</td>");
            out.print("<td>"+e.getCountry()+"</td>");
            out.print("<td><a href='updateServlet?id="+e.getId()+"'>Edit</a></td>");
            out.print("<td><a href='deleteServlet?id="+e.getId()+"'>Delete</a></td>");
            out.print("</tr>");

        }
        out.print("<a href='index.jsp'>back</a>");

        out.print("</table>");
    }



}
