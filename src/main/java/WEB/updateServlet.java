package WEB;

import USERDAO.userDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import MODEL.User;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/UpdateServlet")
public class updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        int id = Integer.parseInt(req.getParameter("id"));
        PrintWriter out = resp.getWriter();
        User u=new User();
        userDao.getUserbyid();
        out.println("<html>");
        out.println("<head><title>Update User</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }");
        out.println("h2 { color: #333; }");
        out.println("table { width: 50%; margin: 0 auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
        out.println("td { padding: 10px; }");
        out.println("input[type='text'], input[type='email'] { width: 100%; padding: 8px; margin: 5px 0; border: 1px solid #ccc; border-radius: 4px; }");
        out.println("input[type='submit'] { background-color: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; }");
        out.println("input[type='submit']:hover { background-color: #45a049; }");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Update User Details</h2>");
        out.println("<form action='UserServlet' method='post'>");
        out.println("<input type='hidden' name='id' value='" + id + "'/>");
        out.println("<table>");
        out.println("<tr><td>Name:</td><td><input type='text' name='name' value='" + u.getName() + "'/></td></tr>");
        out.println("<tr><td>Email:</td><td><input type='email' name='email' value='" + u.getEmail() + "'/></td></tr>");
        out.println("<tr><td>Country:</td><td><input type='text' name='country' value='" + u.getCountry() + "'/></td></tr>");
        out.println("<tr><td colspan='2' style='text-align: center;'><input type='submit' value='Update'/></td></tr>");

        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }
}
