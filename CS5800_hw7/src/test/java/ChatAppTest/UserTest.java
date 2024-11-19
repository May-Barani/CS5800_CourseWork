package ChatAppTest;

import ChatApp.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Iterator;  // <-- Add this line to import Iterator

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private ChatServer chatServer;
    private User alice;
    private User bob;
    private User charlie;

    @BeforeEach
    void setUp() {
        chatServer = new ChatServer();
        alice = new User("Alice", chatServer);
        bob = new User("Bob", chatServer);
        charlie = new User("Charlie", chatServer);
    }

    @Test
    void testSendMessage() {
        Message message = new Message(alice, List.of(bob), "Hello, Bob!");
        alice.sendMessage(message);
        assertTrue(alice.getChatHistory().getSentMessages().contains(message));
    }

    @Test
    void testReceiveMessage() {
        Message message = new Message(alice, List.of(bob), "Hello, Bob!");
        bob.receiveMessage(message);
        assertTrue(bob.getChatHistory().getReceivedMessages().contains(message));
    }

    @Test
    void testBlockUser() {
        bob.blockUser(alice);
        assertTrue(bob.getBlockedUsers().contains(alice));
    }

    @Test
    void testUnsentLastMessage() {
        Message message = new Message(alice, List.of(bob), "Hello, Bob!");
        alice.sendMessage(message);
        alice.undoLastSentMessage();
        assertFalse(alice.getChatHistory().getSentMessages().contains(message));
    }

    @Test
    void testIterateMessagesWithSpecificUser() {
        Message message1 = new Message(alice, List.of(bob), "Message 1");
        Message message2 = new Message(alice, List.of(charlie), "Message 2");
        alice.sendMessage(message1);
        alice.sendMessage(message2);
        bob.receiveMessage(message1);

        int count = 0;
        Iterator<Message> iterator = bob.iterator(alice);
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(1, count);
    }
}
