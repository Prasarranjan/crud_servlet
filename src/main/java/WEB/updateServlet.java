//package WEB;
//
//import USERDAO.userDao;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import MODEL.User;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class updateServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//
//        int id = Integer.parseInt(req.getParameter("id"));
//        PrintWriter out = resp.getWriter();
//        userDao ud = new userDao();
//
//
//            out.println("<html>");
//        out.println("<head><title>Update User</title></head>");
//        out.println("<body>");
//        out.println("<h2>Update User Details</h2>");
//        out.println("<form action='UpdateUserServlet' method='post'>");
//        out.println("<input type='hidden' name='id' value='" + id + "'/>");
//        out.println("<table>");
//        out.println("<tr><td>Name:</td><td><input type='text' name='name' value='" + name + "'/></td></tr>");
//        out.println("<tr><td>Email:</td><td><input type='email' name='email' value='" + email + "'/></td></tr>");
//        out.println("<tr><td>Country:</td><td><input type='text' name='country' value='" + country + "'/></td></tr>");
//        out.println("<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>");
//        out.println("</table>");
//        out.println("</form>");
//        out.println("</body>");
//        out.println("</html>");
//    }
//}
