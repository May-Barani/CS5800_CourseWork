package ChatApp;

public class MessageMemento {
    private final Message message;

    MessageMemento(Message message) {
        this.message = message;
    }

    public Message getPreviousMessage() {
        return message;
    }
}
