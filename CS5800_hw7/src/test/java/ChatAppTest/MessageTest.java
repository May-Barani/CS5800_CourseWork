package ChatAppTest;

import ChatApp.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    private Message message;

    @BeforeEach
    void setUp() {
        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);
        message = new Message(alice, List.of(bob), "Hello, Bob!");
    }

    @Test
    void testMessageCreation() {
        assertNotNull(message.getSender());
        assertEquals("Hello, Bob!", message.getMessageContent());
        assertNotNull(message.getTimestamp());
        assertEquals(1, message.getRecipients().size());
    }

    @Test
    void testSaveToMemento() {
        MessageMemento memento = message.saveToMemento();
        assertNotNull(memento);
        assertEquals("Hello, Bob!", memento.getPreviousMessage().getMessageContent());
    }}
