package carmen.example;

import javax.ejb.*;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * Created by cgray on 7/10/14.
 */
@MessageDriven( activationConfig =
        {
                @ActivationConfigProperty( propertyName = "destinationType", propertyValue = "javax.jms.Queue" ),
                @ActivationConfigProperty( propertyName = "destination", propertyValue = "queue/queueA" ),
                @ActivationConfigProperty( propertyName = "providerAdapterJNDI", propertyValue = "java:/RemoteJMSProvider" ),
                @ActivationConfigProperty( propertyName = "reconnectAttempts", propertyValue = "6000" ),
                @ActivationConfigProperty( propertyName = "reconnectInterval", propertyValue = "5" )
        } )
public class ReconnectingRemoteMDB implements MessageDrivenBean, MessageListener
{
    public void onMessage( final Message message )
    {
        TextMessage text = (TextMessage) message;
        String strMessage = null;
        try
        {
            strMessage = text.getText();
        }
        catch ( JMSException e )
        {
            e.printStackTrace();
        }
        System.out.println( "Message received from MDB: " + strMessage );
    }

    public void setMessageDrivenContext( MessageDrivenContext messageDrivenContext ) throws EJBException
    {

    }

    public void ejbRemove() throws EJBException
    {

    }


}
