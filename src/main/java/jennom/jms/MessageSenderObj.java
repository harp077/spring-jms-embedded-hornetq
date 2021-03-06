package jennom.jms;

import com.google.gson.Gson;
import javax.inject.Inject;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component("objSender")
public class MessageSenderObj { //implements MessageSender {
    
    @Inject
    private Gson gson;
    @Inject
    private JmsTemplate jmsQueueTemplate;

    //@Override
    public void sendMessage(String destinationNameQ, User user) {
        // setDeliveryDelay() = error: throw exception in embedded mode ! 
        //jmsQueueTemplate.setDeliveryDelay(555L);
        this.jmsQueueTemplate.convertAndSend(destinationNameQ, user);
        //loggerBean.info(" >>> Sending obj user = " + gson.toJson(user));
        System.out.println(" >>> Sending obj user GSON = " + gson.toJson(user));
    }
}
