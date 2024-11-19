package ChatApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements IterableByUser {
    private List<Message> sentMessages;
    private List<Message> receivedMessages;

    public ChatHistory() {
        sentMessages = new ArrayList<>();
        receivedMessages = new ArrayList<>();
    }

    public void addReceivedMessage(Message message) {
        receivedMessages.add(message);
    }

    public void addSentMessage(Message message) {
        sentMessages.add(message);
    }

    public Message getLastSentMessages() {
        return sentMessages.isEmpty() ? null : sentMessages.get(sentMessages.size() - 1);
    }

    public void removeLastSentMessage(Message message) {
        sentMessages.remove(message);
    }

    public void removeLastReceivedMessage(Message message) {
        receivedMessages.remove(message);
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    // Add this method to access receivedMessages in tests
    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public List<Message> combineMessages() {
        List<Message> combinedMessages = new ArrayList<>(receivedMessages);
        combinedMessages.addAll(sentMessages);
        return combinedMessages;
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return new SearchMessagesByUser(combineMessages().iterator(), userToSearchWith);
    }
}
