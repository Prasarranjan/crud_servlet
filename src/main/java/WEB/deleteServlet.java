package WEB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import USERDAO.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        int empId=Integer.parseInt(req.getParameter("id"));
        userDao ed=new userDao();
        int status=ed.deleteUser(empId);

        if (status>0) {
            out.println("<h2 style='color:green;'>Deleted Successfully!</h2>");
            out.print("<a href='viewServlet'>back</a>");

        } else {
            out.println("<h2 style='color:red;'>Deletion Failed!</h2>");
            out.print("<a href='viewServlet'>back</a>");
        }
    }
}
