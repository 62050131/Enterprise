/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsprimeserver;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author sarun
 */
public class TextListener implements MessageListener {
    private MessageProducer replyProducer;
    private Session session;
    
    private boolean isPrime(int n) {
    int i;
    for (i = 2; i*i <= n; i++) {
        if ((n % i) == 0) {
            return false;
        }
    }
    return true;
    }
    
    public TextListener(Session session) {
              
        this.session = session;
        try {
            replyProducer = session.createProducer(null);
        } catch (JMSException ex) {
            Logger.getLogger(TextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void onMessage(Message message) {
        TextMessage msg = null;
        String []spword;
        String word;
        int count=0;
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                System.out.println("Reading message: " + msg.getText());
                
            } else {
                System.err.println("Message is not a TextMessage");
            }
            //split ,
            word= msg.getText();
//            System.out.println("word is "+word);
            spword = word.split(",");
//            System.out.println("first is "+spword[0]);
//            System.out.println("last is "+spword[1]);
            //count prime number
            int first=Integer.parseInt(spword[0]);
            int last=Integer.parseInt(spword[1]);
            
            
            for(int i=first;i<=last;i++){
                if(isPrime(i)==true){
                    count+=1;
                }
            }
            
            // set up the reply message 
            TextMessage response = session.createTextMessage("The number of prime between "+ spword[0]+" and "+spword[1]+" is "+count); 
            response.setJMSCorrelationID(message.getJMSCorrelationID()); 
            System.out.println("sending message " + response.getText());
            replyProducer.send(message.getJMSReplyTo(), response);
        } catch (JMSException e) {
            System.err.println("JMSException in onMessage(): " + e.toString());
        } catch (Throwable t) {
            System.err.println("Exception in onMessage():" + t.getMessage());
        }
        
    }
}
