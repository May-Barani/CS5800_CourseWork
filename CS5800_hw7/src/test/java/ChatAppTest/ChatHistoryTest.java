package ChatAppTest;

import ChatApp.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ChatHistoryTest {
    private ChatHistory chatHistory;
    private User alice;
    private User bob;

    @BeforeEach
    void setUp() {
        chatHistory = new ChatHistory();
        ChatServer chatServer = new ChatServer();
        alice = new User("Alice", chatServer);
        bob = new User("Bob", chatServer);
    }

    @Test
    void testAddSentMessage() {
        Message message = new Message(alice, List.of(bob), "Hello, Bob!");
        chatHistory.addSentMessage(message);
        assertTrue(chatHistory.getSentMessages().contains(message));
    }

    @Test
    void testAddReceivedMessage() {
        Message message = new Message(alice, List.of(bob), "Hello, Bob!");
        chatHistory.addReceivedMessage(message);
        assertTrue(chatHistory.getReceivedMessages().contains(message));
    }

    @Test
    void testGetLastSentMessage() {
        Message message = new Message(alice, List.of(bob), "Last sent message test.");
        chatHistory.addSentMessage(message);
        assertEquals(message, chatHistory.getLastSentMessages());
    }

    @Test
    void testRemoveLastSentMessage() {
        Message message = new Message(alice, List.of(bob), "Removing sent message test.");
        chatHistory.addSentMessage(message);
        chatHistory.removeLastSentMessage(message);
        assertFalse(chatHistory.getSentMessages().contains(message));
    }

    @Test
    void testRemoveLastReceivedMessage() {
        Message message = new Message(alice, List.of(bob), "Removing received message test.");
        chatHistory.addReceivedMessage(message);
        chatHistory.removeLastReceivedMessage(message);
        assertFalse(chatHistory.getReceivedMessages().contains(message));
    }

    @Test
    void testIteratorWithSpecificUser() {
        Message message1 = new Message(alice, List.of(bob), "Message 1");
        Message message2 = new Message(alice, List.of(bob), "Message 2");
        chatHistory.addSentMessage(message1);
        chatHistory.addReceivedMessage(message2);

        int count = 0;
        Iterator<Message> iterator = chatHistory.iterator(bob);
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(2, count);
    }
}
