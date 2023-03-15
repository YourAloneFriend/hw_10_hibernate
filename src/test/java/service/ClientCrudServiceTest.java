package service;

import org.application.entity.Client;
import org.application.entity.Ticket;
import org.application.service.ClientCrudService;
import org.application.service.impl.ClientCrudServiceImpl;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientCrudServiceTest {

    private static ClientCrudService service;

    @BeforeAll
    static void setUp(){
        service = new ClientCrudServiceImpl();
    }

    @Test
    @Order(1)
    void testCreateClient(){
        Client client = new Client();
        client.setId(11);
        client.setName("Sergay");
        service.createClient(client);
    }

    @Test
    @Order(2)
    void testUpdateClient(){
        Client client = new Client();
        client.setId(11);
        client.setName("Marcenkevich");
        service.updateClient(client);
    }

    @Test
    @Order(3)
    void testGetClient(){
        Client client = service.getClient(11);
        Assertions.assertEquals("Marcenkevich", client.getName());
    }

    @Test
    @Order(4)
    void testGetAllClient(){
        List<Client> clients = service.getAllClients();
        for (Client client : clients)
            System.out.println("Client: " + client.getId() + ", " + client.getName());
        Assertions.assertEquals(11, clients.size());
    }

    @Test
    @Order(5)
    void testRemoveClient(){
        service.removeClient(11);
        Client client = service.getClient(11);
        Assertions.assertNull(client);
    }

    @Test
    @Order(6)
    void testCreateTicket(){
        Ticket ticket = new Ticket();
        ticket.setId(1);
        ticket.setClientId(1);
        ticket.setToPlanetId("EU");
        ticket.setFromPlanetId("MN");
        ticket.setCreatedAt(LocalDateTime.now());
        service.addTicket(ticket);
    }

    @Test
    @Order(7)
    void testGetTicket(){
        Ticket ticket = service.getTicket(1);
        Assertions.assertNotNull(ticket);
    }

    @Test
    @Order(8)
    void testRemoveTicket(){
        service.removeTicket(1);
        Ticket ticket = service.getTicket(1);
        Assertions.assertNull(ticket);
    }
}
