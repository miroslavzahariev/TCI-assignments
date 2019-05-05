import java.util.ArrayList;
import java.util.List;

public class Client implements IClient {

    private String name;
    private List<SportMessage> messages;
    private Boolean subscribedToFootball = false;

    public void setMessages(List<SportMessage> messages) {
        this.messages = messages;
    }

    public List<SportMessage> getMessages() {
        return messages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private Boolean subscribedToF1 = false;

    public void setSubscribedToFootball(Boolean subscribedToFootball) {
        this.subscribedToFootball = subscribedToFootball;
    }

    public void setSubscribedToF1(Boolean subscribedToF1) {
        this.subscribedToF1 = subscribedToF1;
    }

    public Boolean getSubscribedToFootball() {
        return subscribedToFootball;
    }

    public Boolean getSubscribedToF1() {
        return subscribedToF1;
    }

    public Client(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
    }

    @Override
    public void ReceiveMessage(SportMessage message) {
        messages.add(message);
    }
}
