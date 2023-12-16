import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) {
        // Configuration de la fabrique de connexions pour le consommateur
        ConnectionFactory cnnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            // Création d'une connexion
            Connection connection = cnnectionFactory.createConnection();
            connection.start();
            // Création d'une connexion
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("my topic.topic");
            MessageConsumer consumer =session.createConsumer(destination);
            // Définition d'un écouteur de messages pour le consommateur
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    // Traitement des messages reçus (ici, affichage du texte pour les messages de type TextMessage)
                    if (message instanceof TextMessage){
                        TextMessage textMessage =(TextMessage) message;
                        try {
                            System.out.println("message recu"+textMessage.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }

                    }}
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}