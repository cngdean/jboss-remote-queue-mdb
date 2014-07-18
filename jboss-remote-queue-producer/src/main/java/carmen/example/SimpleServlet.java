package carmen.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet
{

    public void doGet( HttpServletRequest request,
            HttpServletResponse response )
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        try
        {
            out.println(new QueueExample().example());
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}
