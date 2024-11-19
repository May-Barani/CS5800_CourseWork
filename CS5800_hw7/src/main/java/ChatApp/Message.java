package ChatApp;

import java.util.Date;
import java.util.List;

public class Message {
    private User sender;
    private List<User> recipients;
    private String messageContent;
    private Date timestamp;

    public Message(User sender, List<User> recipients, String messageContent) {
        this.sender = sender;
        this.recipients = recipients;
        this.messageContent = messageContent;
        this.timestamp = new Date();
    }

    public MessageMemento saveToMemento() {
        return new MessageMemento(this);
    }

    public void restoreFromMemento(MessageMemento messageMemento) {
        Message previousMessage = messageMemento.getPreviousMessage();
        this.sender = previousMessage.getSender();
        this.recipients = previousMessage.getRecipients();
        this.messageContent = previousMessage.getMessageContent();
        this.timestamp = previousMessage.getTimestamp();
    }

    public User getSender() {
        return sender;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    // Add this setter to allow modifying message content in tests
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        return String.format("%s: Message content: '%s'", timestamp.toString(), messageContent);
    }
}
