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
        PrintWriter out = resp.getWriter();

        userDao ed = new userDao();
        List<User> listEmp = ed.selectUser();

        out.print("<style>");
        out.print("table { width: 100%; border-collapse: collapse; margin: 20px 0; font-family: Arial, sans-serif; }");
        out.print("th, td { padding: 12px; text-align: left; border: 1px solid #ddd; }");
        out.print("th { background-color: #4CAF50; color: white; }");
        out.print("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.print("tr:hover { background-color: #ddd; }");
        out.print("a { text-decoration: none; color: #4CAF50; }");
        out.print("a:hover { color: #45a049; }");

        // CSS for the 'back' link styled as a button
        out.print(".btn-back {");
        out.print("display: inline-block;");
        out.print("margin-top: 20px;");
        out.print("padding: 10px 15px;");
        out.print("background-color: #007bff;");
        out.print("color: white;");
        out.print("text-decoration: none;");
        out.print("border-radius: 5px;");
        out.print("text-align: center;");
        out.print("}");
        out.print(".btn-back:hover {");
        out.print("background-color: #0056b3;");
        out.print("}");

        out.print("</style>");

        out.print("<table>");
        out.print("<tr>");
        out.print("<th>ID</th>");
        out.print("<th>NAME</th>");
        out.print("<th>EMAIL</th>");
        out.print("<th>COUNTRY</th>");
        out.print("<th>EDIT</th>");
        out.print("<th>DELETE</th>");
        out.print("</tr>");

        for (User e : listEmp) {
            out.print("<tr>");
            out.print("<td>" + e.getId() + "</td>");
            out.print("<td>" + e.getName() + "</td>");
            out.print("<td>" + e.getEmail() + "</td>");
            out.print("<td>" + e.getCountry() + "</td>");
            out.print("<td><a href='UpdateServlet?id=" + e.getId() + "'>Edit</a></td>");
            out.print("<td><a href='deleteServlet?id=" + e.getId() + "'>Delete</a></td>");
            out.print("</tr>");
        }

        out.print("</table>");

        out.print("<a href='index.jsp' class='btn-back'>Back</a>");

        out.print("</table>");
    }
}
