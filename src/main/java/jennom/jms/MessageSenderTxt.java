package jennom.jms;

import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("txtSender")
public class MessageSenderTxt { //implements MessageSender {
    
    @Inject
    private JmsTemplate jmsQueueTemplate;
    @Inject
    private JmsTemplate jmsTopicTemplate;    

    //@Override
    public void sendMessageQ(String destinationNameQ, String message) {
        // setDeliveryDelay() = error: throw exception in embedded mode !
        //jmsQueueTemplate.setDeliveryDelay(500L);
        this.jmsQueueTemplate.send(destinationNameQ, new MessageCreator() {
            @Override
            public Message createMessage(Session session)
                    throws JMSException {
                TextMessage jmsMessage = session.createTextMessage(message);
                System.out.println(">>> sendMessageQ -> Sending txt user: " + jmsMessage.getText());
                return jmsMessage;
            }
        });
    }
    
    public void sendMessageT(String destinationNameQ, String message) {
        //jmsTopicTemplate.setDeliveryDelay(500L);
        this.jmsTopicTemplate.send(destinationNameQ, new MessageCreator() {
            @Override
            public Message createMessage(Session session)
                    throws JMSException {
                TextMessage jmsMessage = session.createTextMessage(message);
                System.out.println(">>> sendMessageT -> Sending txt user: " + jmsMessage.getText());
                return jmsMessage;
            }
        });
    }    
    
}
