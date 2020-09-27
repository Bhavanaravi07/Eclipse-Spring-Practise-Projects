package com.dxc.message;
import java.util.Properties;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext; 
public class AsyncReceiver implements MessageListener, ExceptionListener {
 static QueueConnection queueConn = null;
 public static void main(String[] args) throws Exception {
 Properties env = new Properties();
 env.put(Context.INITIAL_CONTEXT_FACTORY,
"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
 env.put(Context.PROVIDER_URL, "tcp://localhost:61616");
 env.put("queue.queueSampleQueue", "MyNewQueue");

 InitialContext ctx = new InitialContext(env);
 Queue queue = (Queue) ctx.lookup("queueSampleQueue");
 QueueConnectionFactory connFactory = (QueueConnectionFactory)
ctx.lookup("QueueConnectionFactory");
 queueConn = connFactory.createQueueConnection();
 QueueSession queueSession =
queueConn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
 QueueReceiver queueReceiver = queueSession.createReceiver(queue);
 AsyncReceiver asyncReceiver = new AsyncReceiver();
 queueReceiver.setMessageListener(asyncReceiver);
 queueConn.setExceptionListener(asyncReceiver);
 queueConn.start();
 }
 public void onMessage(Message message) {
 TextMessage msg = (TextMessage) message;
 try {
 if (msg.getText().equals("exit")) {
 queueConn.close();
 System.out.println("Application Exits");
 } else {
 System.out.println("received: " + msg.getText());
 }
 } catch (JMSException ex) {
 ex.printStackTrace();
 }
 }
 public void onException(JMSException exception) {
 System.err.println("an error occurred: " + exception);
 }
}