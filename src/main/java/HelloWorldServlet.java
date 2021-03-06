import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = "")

public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // <----- this is default content type
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name"); // <---- /hello?name=namehere

        if (name != null) {
            out.println("<h1>Hello, " + name + "</h1>");
        } else {
            out.println("<h1>Hello, World!</h1>");
        }
    }
}