package ChatApp;

import java.util.ArrayList;
import java.util.List;

public class ChatServer implements ChatMediator {
    private List<User> users;

    public ChatServer() {
        users = new ArrayList<>();
    }

    @Override
    public void sendMessage(Message message) {
        User sender = message.getSender();
        List<User> receivers = new ArrayList<>(message.getRecipients());
        if (!users.contains(sender)) {
            System.out.printf("Cannot send message as user %s is not registered.\n", sender.getUsername());
            return;
        }
        List<User> validReceivers = new ArrayList<>();
        for (User user : receivers) {
            if (!users.contains(user)) {
                System.out.printf("Cannot send message from %s to %s as user %s is not registered.\n", sender.getUsername(), user.getUsername(), user.getUsername());
            } else {
                validReceivers.add(user);
            }
        }
        for (User receiver : validReceivers) {
            if (receiver.getBlockedUsers().contains(sender)) {
                System.out.printf("Cannot send message from %s to %s because %s is blocked by %s.\n", sender.getUsername(), receiver.getUsername(), sender.getUsername(), receiver.getUsername());
            } else {
                sender.sendMessage(message);
                receiver.receiveMessage(message);
                System.out.printf("%s: %s received message from %s: '%s'\n", message.getTimestamp(), receiver.getUsername(), sender.getUsername(), message.getMessageContent());
            }
        }
    }

    @Override
    public void registerUser(User user) {
        users.add(user);
        System.out.printf("Successfully registered user %s\n", user.getUsername());
    }

    @Override
    public void unregisterUser(User user) {
        users.remove(user);
        System.out.printf("Unregistered user %s\n", user.getUsername());
    }

    @Override
    public void blockMessages(String blockerUsername, String blockeeUsername) {
        User blocker = findUserByUsername(blockerUsername);
        User blockee = findUserByUsername(blockeeUsername);

        if (blocker == null || blockee == null) {
            System.out.println("Either blocker or blockee user not found.");
            return;
        }

        if (blocker.getBlockedUsers().contains(blockee)) {
            System.out.printf("User %s has already blocked user %s.\n", blockerUsername, blockeeUsername);
        } else {
            blocker.getBlockedUsers().add(blockee);
            System.out.printf("User %s has blocked user %s.\n", blockerUsername, blockeeUsername);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void undoLastMessage(User user) {
        List<Message> sentMessages = user.getChatHistory().getSentMessages();
        if (sentMessages.isEmpty()) {
            System.out.printf("Cannot un-send last message as user %s has not sent any messages.\n", user.getUsername());
            return;
        }
        Message lastMessage = user.getChatHistory().getLastSentMessages();
        user.undoLastSentMessage();
        for (User receiver : lastMessage.getRecipients()) {
            receiver.getChatHistory().removeLastReceivedMessage(lastMessage);
        }

        // Feedback for the unsent action
        System.out.printf("User %s unsent their last message.\n", user.getUsername());
    }

    private User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
