import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class RaceResultService {

    private Collection<Client> clients = new HashSet<Client>();
    private IMessageLogger logger;

    public RaceResultService(IMessageLogger logger) {
        this.logger = logger;
    }

    public void addSubscriber(Client client)
    {
        clients.add(client);
    }

    public void sendFootballMessages(SportMessage message, Date date) {

        for (Client client : clients) {
            if (client.getSubscribedToFootball()){
                client.ReceiveMessage(message);
                logger.LogMessage(message, date);
            }
        }
    }

    public void sendF1Messages(SportMessage message, Date date){

        for (Client client : clients) {
            if (client.getSubscribedToF1()){
                client.ReceiveMessage(message);
                logger.LogMessage(message, date);
            }
        }
    }

    public Boolean removeSubscriber(Client client)
    {
        int numberOfClientsRemoved = 0;
        for(Client cl : clients){
            if (cl.getName() == client.getName()){
                clients.remove(client);
                return true;
            }
        }

        return false;
    }

    public Boolean SubscribeUserToF1(Client clientToSubscribe){

        for (Client client : clients){
            if (client.getName().equals(clientToSubscribe.getName())){
                client.setSubscribedToF1(true);

                return true;
            }
        }

        return false;
    }

    public Boolean SubscribeUserToFootball(Client clientToSubscribe){

        for (Client client : clients){
            if (client.getName().equals(clientToSubscribe.getName())){
                client.setSubscribedToFootball(true);

                return true;
            }
        }

        return false;
    }
}
