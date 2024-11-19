package ChatApp;

public interface ChatMediator {
    void sendMessage(Message message);
    void registerUser(User user);
    void unregisterUser(User user);
    void blockMessages(String blocker, String blockee);
}
