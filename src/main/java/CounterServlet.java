import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by HKoehler on 1/30/17.
 */


@WebServlet(name="CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int counter = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
                counter += 1;
                response.getWriter().println("<h1>The count is " + counter + ".</h1>");
    }
}
