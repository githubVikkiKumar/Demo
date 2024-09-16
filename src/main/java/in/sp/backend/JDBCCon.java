package in.sp.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/regForm")
public class JDBCCon extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String myname = req.getParameter("name");
        String myemail = req.getParameter("email");
        String mypass = req.getParameter("pass");
        String mygender = req.getParameter("gender");
        String mycity = req.getParameter("city1");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (myname == null || myname.isEmpty() ||
            myemail == null || myemail.isEmpty() ||
            mypass == null || mypass.isEmpty() ||
            mygender == null || mygender.isEmpty() ||
            mycity == null || mycity.isEmpty()) {

            out.print("<h3 style='color:red'>All fields are required. Please fill the form completely.</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
            rd.include(req, resp);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "vikki1234");
            PreparedStatement ps = con.prepareStatement("INSERT INTO register (name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, myname);
            ps.setString(2, myemail);
            ps.setString(3, mypass);
            ps.setString(4, mygender);
            ps.setString(5, mycity);

            int count = ps.executeUpdate();
            if (count > 0) {
                out.print("<h3 style='color:green'>User registered successfully</h3>");
            } else {
                out.print("<h3 style='color:red'>User registration failed due to some error</h3>");
            }
            RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
            rd.include(req, resp);

        } catch (Exception e) {
            out.print("<h3 style='color:red'>An error occurred: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Implement this method if needed
    }
}
