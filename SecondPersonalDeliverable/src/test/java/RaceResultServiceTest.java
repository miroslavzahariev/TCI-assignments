import net.bytebuddy.build.ToStringPlugin;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.*;

public class RaceResultServiceTest {

    @Test
    public void SendFootballMessages_SendsMessagesOnlyToClientsSubscribedToFootbal(){

        // Arrange
        Client footballClient = Mockito.mock(Client.class, "John");
        Client f1Client = Mockito.mock(Client.class, "Jack");
        IMessageLogger logger = Mockito.mock(IMessageLogger.class);
        RaceResultService service = new RaceResultService(logger);
        SportMessage message = new SportMessage();
        Date date = new Date();

        Mockito.when(footballClient.getName()).thenReturn("John");
        Mockito.when(f1Client.getName()).thenReturn("Jack");
        Mockito.when(footballClient.getSubscribedToFootball()).thenReturn(true);
        Mockito.when(f1Client.getSubscribedToFootball()).thenReturn(false);

        service.addSubscriber(footballClient);
        service.addSubscriber(f1Client);
        service.SubscribeUserToFootball(footballClient);
        service.SubscribeUserToF1(f1Client);

        // Act
        for (int i = 0; i < 5 ; i++){
            service.sendFootballMessages(message, date);
        }


        //Assert
        Mockito.verify(footballClient, Mockito.times(5)).ReceiveMessage(message);
        Mockito.verify(f1Client, Mockito.never()).ReceiveMessage(message);
    }

    @Test
    public void SendFootballMessages_SendsToNoOne_WhenNoClientIsSubscribedToFootball(){
        // Arrange
        Client footballClient = Mockito.mock(Client.class, "John");
        Client f1Client = Mockito.mock(Client.class, "Jack");
        IMessageLogger logger = Mockito.mock(IMessageLogger.class);
        RaceResultService service = new RaceResultService(logger);
        SportMessage message = new SportMessage();
        Date date = new Date();

        Mockito.when(footballClient.getName()).thenReturn("John");
        Mockito.when(f1Client.getName()).thenReturn("Jack");
        Mockito.when(footballClient.getSubscribedToFootball()).thenReturn(false);
        Mockito.when(f1Client.getSubscribedToFootball()).thenReturn(false);

        service.addSubscriber(footballClient);
        service.addSubscriber(f1Client);

        // Act
        service.sendFootballMessages(message, date);

        //Assert
        Mockito.verify(footballClient, Mockito.never()).ReceiveMessage(message);
        Mockito.verify(f1Client, Mockito.never()).ReceiveMessage(message);
    }

    @Test
    public void SendF1Messages_SendsMessagesOnlyToClientsSubscribedToF1(){

        // Arrange
        Client footballClient = Mockito.mock(Client.class, "John");
        Client f1Client = Mockito.mock(Client.class, "Jack");
        IMessageLogger logger = Mockito.mock(IMessageLogger.class);
        RaceResultService service = new RaceResultService(logger);
        SportMessage message = new SportMessage();
        Date date = new Date();

        Mockito.when(footballClient.getName()).thenReturn("John");
        Mockito.when(f1Client.getName()).thenReturn("Jack");
        Mockito.when(footballClient.getSubscribedToF1()).thenReturn(false);
        Mockito.when(f1Client.getSubscribedToF1()).thenReturn(true);

        service.addSubscriber(footballClient);
        service.addSubscriber(f1Client);
        service.SubscribeUserToFootball(footballClient);
        service.SubscribeUserToF1(f1Client);

        // Act
        for (int i = 0; i < 5; i ++){
            service.sendF1Messages(message, date);
        }

        //Assert
        Mockito.verify(f1Client, Mockito.times(5)).ReceiveMessage(message);
        Mockito.verify(footballClient, Mockito.never()).ReceiveMessage(message);
    }

    @Test
    public void SendF1Messages_SendsToNoOne_WhenNoClientIsSubscribedToF1(){
        // Arrange
        Client footballClient = Mockito.mock(Client.class, "John");
        Client f1Client = Mockito.mock(Client.class, "Jack");
        IMessageLogger logger = Mockito.mock(IMessageLogger.class);
        RaceResultService service = new RaceResultService(logger);
        SportMessage message = new SportMessage();
        Date date = new Date();

        Mockito.when(footballClient.getName()).thenReturn("John");
        Mockito.when(f1Client.getName()).thenReturn("Jack");
        Mockito.when(footballClient.getSubscribedToF1()).thenReturn(false);
        Mockito.when(f1Client.getSubscribedToF1()).thenReturn(false);

        service.addSubscriber(footballClient);
        service.addSubscriber(f1Client);

        // Act
        service.sendF1Messages(message, date);

        //Assert
        Mockito.verify(footballClient, Mockito.never()).ReceiveMessage(message);
        Mockito.verify(f1Client, Mockito.never()).ReceiveMessage(message);
    }

    @Test
    public void SendF1Message_EnsureLoggingIsBeingCalledForEachMessage(){

        // Arrange
        Client client = new Client("Jack");
        IMessageLogger logger = Mockito.mock(IMessageLogger.class);
        SportMessage message = new SportMessage();
        Date messageDate = new Date();
        RaceResultService service = new RaceResultService(logger);
        service.addSubscriber(client);
        service.SubscribeUserToF1(client);
        int numberOfTimesMessageShouldBeLogged = 5;

        // Act
        for (int i = 0; i < numberOfTimesMessageShouldBeLogged ; i++){
            service.sendF1Messages(message, messageDate);
        }

        //Assert
        Mockito.verify(logger, Mockito.times(numberOfTimesMessageShouldBeLogged))
                .LogMessage(message, messageDate);
    }

    @Test
    public void UnsubscribeClient_ReturnsTrue_WhenClientIsSubscribed(){

        // Arrange
        Client client = new Client("Jack");
        IMessageLogger logger = new Mockito().mock(IMessageLogger.class);
        RaceResultService service = new RaceResultService(logger);
        service.addSubscriber(client);

        // Act
        Boolean result = service.removeSubscriber(client);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void UnsubscribeClient_ReturnsFalse_WhenClientIsNotSubscribed(){
        // Arrange
        Client client = new Client("Jack");
        IMessageLogger logger = new Mockito().mock(IMessageLogger.class);
        RaceResultService service = new RaceResultService(logger);

        // Act
        Boolean result = service.removeSubscriber(client);

        // Assert
        Assert.assertFalse(result);
    }
}