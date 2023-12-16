import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
//creation de connection  1ere etape  connection create   session create    destination  mode file d'attente type topic produceur yekteb el msg  na3tih el space li bech yekteb fih
// text msg envoyer apartir send de producer
public class Producer {
    public static void main(String[] args) {
        // Configuration de la fabrique de connexions pour le producteur
        ConnectionFactory cnnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
           Connection connection = cnnectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            Destination destination =session.createTopic("my topic.topic");
            // Création d'un producteur pour la destination spécifiée
            MessageProducer producer = session.createProducer(destination);
            // Création d'un producteur pour la destination spécifiée
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("hello hello ");
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            producer.send(textMessage);
            // Confirmation de la transaction
            session.commit();
            producer.close();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
