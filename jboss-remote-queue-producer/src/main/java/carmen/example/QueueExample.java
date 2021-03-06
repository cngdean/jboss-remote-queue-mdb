package carmen.example;

import javax.jms.*;
import javax.naming.Context;
import java.util.Properties;

public class QueueExample
{
    public String example() throws Exception
    {
        String destinationName = "queue/queueA";
        String humanNumber = "Error, no human generated";

        Context ic = null;
        ConnectionFactory cf = null;
        Connection connection = null;

        try
        {
            ic = getInitialContext();

            cf = (ConnectionFactory) ic.lookup( "/ConnectionFactory" );
            Queue queue = (Queue) ic.lookup( destinationName );

            connection = cf.createConnection();
            Session session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE );
            MessageProducer publisher = session.createProducer( queue );
            connection.start();

            humanNumber = "Greetings Human Number " + Math.random();
            System.out.println( "Sending: " + humanNumber );
            TextMessage message = session.createTextMessage( humanNumber );
            publisher.send( message );
        }
        finally
        {
            if ( ic != null )
            {
                try
                {
                    ic.close();
                }
                catch ( Exception e )
                {
                    throw e;
                }
            }

            closeConnection( connection );
        }
        return humanNumber;
    }

    private void closeConnection( Connection con )
    {
        try
        {
            if ( con != null )
            {
                con.close();
            }
        }
        catch ( JMSException jmse )
        {
            System.out.println( "Could not close connection " + con + " exception was " + jmse );
        }
    }

    public static void main( String[] args ) throws Exception
    {
        new QueueExample().example();
    }

    public static Context getInitialContext()
            throws javax.naming.NamingException
    {

        Properties p = new Properties();
        p.put( Context.INITIAL_CONTEXT_FACTORY,
                "org.jnp.interfaces.NamingContextFactory" );
        p.put( Context.URL_PKG_PREFIXES,
                " org.jboss.naming:org.jnp.interfaces" );
        p.put( Context.PROVIDER_URL, "jnp://localhost:1099");//jnp://localhost:1099" );
        return new javax.naming.InitialContext( p );
    }
}

