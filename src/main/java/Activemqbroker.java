import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerService;

public class Activemqbroker {
    public static void main(String[] args) {
        BrokerService brokerService = new BrokerService();
        try {
            // Ajout d'un connecteur sur le port 61616
            brokerService.addConnector("tcp://0.0.0.0:61616");
            // Démarrage du broker
            brokerService.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
