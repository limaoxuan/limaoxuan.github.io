import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(urlPatterns = "/support")
public class SupportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String str = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "\n" +
                "    <form method='post'>\n" +
                "        <div>\n" +
                "            <fieldset>\n" +
                "                <legend>Name:</legend>\n" +
                "                <input name=\"name\" type=\"text\" placeholder=\"Name\" required/>\n" +
                "            </fieldset>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <fieldset>\n" +
                "                <legend>Email address:</legend>\n" +
                "                <input name=\"email\" type=\"email\" placeholder=\"Email address\" required/>\n" +
                "            </fieldset>\n" +
                "\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <fieldset>\n" +
                "                <legend>Problem</legend>\n" +
                "                <input name=\"problem\" type=\"text\" placeholder=\"Problem\"/>\n" +
                "            </fieldset>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <fieldset>\n" +
                "                <legend>Problem description</legend>\n" +
                "                <textarea name=\"problemDes\">\n" +
                "             </textarea>\n" +
                "            </fieldset>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <input type=\"submit\" value=\"help\"/>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        out.print(str);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        ServletContext sc = this.getServletContext();
        String supportEmail = sc.getInitParameter("support-email");
        UUID uuid = UUID.randomUUID();

        String res = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div>\n" +
                "    <fieldset>\n" +
                "        <legend>FeedBack</legend>\n" +
                "        Thank you! <strong>" +
                name +
                "</strong> for contacting us. We should receive reply from us with in 24 hrs in your\n" +
                "        email address\n" +
                "        <strong>" +
                email +
                "</strong> . Let us know in our support email\n" +
                "        <strong>" +
                supportEmail +
                "</strong>\n" +
                "        if you don’t receive reply within 24 hrs. Please be sure to attach your reference\n" +
                "        <strong>" +
                uuid +
                "</strong> in your email.\n" +
                "    </fieldset>\n" +
                "    \n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        PrintWriter out = resp.getWriter();
        out.print(res);
    }
}
