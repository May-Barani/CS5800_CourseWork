package ChatAppTest;

import ChatApp.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChatServerTest {
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
    void testRegisterUser() {
        chatServer.registerUser(alice);
        assertTrue(chatServer.getUsers().contains(alice));
    }

    @Test
    void testUnregisterUser() {
        chatServer.unregisterUser(alice);
        assertFalse(chatServer.getUsers().contains(alice));
    }

    @Test
    void testSendMessage() {
        Message message = new Message(alice, List.of(bob), "Hello, Bob!");
        chatServer.sendMessage(message);
        assertTrue(bob.getChatHistory().getReceivedMessages().contains(message));
    }

    @Test
    void testBlockMessages() {
        chatServer.blockMessages("Bob", "Alice");
        Message message = new Message(alice, List.of(bob), "Blocked message test.");
        chatServer.sendMessage(message);
        assertFalse(bob.getChatHistory().getReceivedMessages().contains(message));
    }

    @Test
    void testUndoLastMessage() {
        Message message = new Message(alice, List.of(bob), "Undo message test.");
        chatServer.sendMessage(message);
        chatServer.undoLastMessage(alice);
        assertFalse(bob.getChatHistory().getReceivedMessages().contains(message));
    }
}
