package ChatApp;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SearchMessagesByUser implements Iterator<Message> {
    private final Iterator<Message> messageIterator;
    private final User userToSearchWith;
    private Message nextMessage = null;

    public SearchMessagesByUser(Iterator<Message> messageIterator, User userToSearchWith) {
        this.messageIterator = messageIterator;
        this.userToSearchWith = userToSearchWith;
    }

    @Override
    public boolean hasNext() {
        while (messageIterator.hasNext()) {
            Message message = messageIterator.next();
            if (message.getSender().equals(userToSearchWith) ||
                    message.getRecipients().contains(userToSearchWith)) {
                nextMessage = message;
                return true;
            }
        }
        return false;
    }

    @Override
    public Message next() {
        if (nextMessage == null && !hasNext()) {
            throw new NoSuchElementException();
        }
        Message result = nextMessage;
        nextMessage = null;
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
