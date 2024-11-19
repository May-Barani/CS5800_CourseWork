package ChatApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User implements IterableByUser {
    private String username;
    private ChatServer chatServer;
    private ChatHistory chatHistory;
    private List<MessageMemento> messageMementos;
    private List<User> blockedUsers;

    public User(String username, ChatServer chatServer) {
        this.username = username;
        this.chatServer = chatServer;
        chatServer.registerUser(this);
        this.chatHistory = new ChatHistory();
        this.messageMementos = new ArrayList<>();
        this.blockedUsers = new ArrayList<>();
    }

    public void undoLastSentMessage() {
        List<Message> sentMessages = chatHistory.getSentMessages();
        if (!sentMessages.isEmpty()) {
            Message lastMessage = sentMessages.remove(sentMessages.size() - 1);
            MessageMemento messageMemento = lastMessage.saveToMemento();
            messageMementos.add(messageMemento);
            System.out.printf("Last message from %s unsent.\n", username);
        } else {
            System.out.printf("No messages to undo for user %s.\n", username);
        }
    }

    public void sendMessage(Message message) {
        this.chatHistory.addSentMessage(message);
    }

    public void receiveMessage(Message message) {
        this.chatHistory.addReceivedMessage(message);
    }

    public String getUsername() {
        return username;
    }

    public void blockUser(User blockedUser) {
        if (!blockedUsers.contains(blockedUser)) {
            blockedUsers.add(blockedUser);
            System.out.printf("User %s has blocked user %s.\n", username, blockedUser.getUsername());
        }
    }

    public List<User> getBlockedUsers() {
        return blockedUsers;
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return chatHistory.iterator(userToSearchWith);
    }
}
