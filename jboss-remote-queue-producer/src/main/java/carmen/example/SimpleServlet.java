package carmen.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleServlet extends HttpServlet
{

    public void doGet( HttpServletRequest request,
            HttpServletResponse response )
            throws ServletException, IOException
    {
        try
        {
            new QueueExample().example();
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }


}
