package ChatApp;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        System.out.println("===== User Registration =====");
        User may = new User("May", chatServer);
        User hera = new User("Hera", chatServer);
        User anna = new User("Anna", chatServer);
        User cece = new User("CeCe", chatServer);
        System.out.println();

        System.out.println("===== Message Sending =====");
        chatServer.sendMessage(new Message(may, List.of(hera), "Hera, have you tried that new Italian place downtown?"));
        chatServer.sendMessage(new Message(cece, List.of(hera), "Hera, I found a sushi place with amazing reviews!"));
        chatServer.sendMessage(new Message(hera, List.of(may), "Not yet, May! But I heard it's amazing. We should go together!"));
        chatServer.sendMessage(new Message(may, List.of(anna), "Anna, do you know any good spots for brunch?"));
        chatServer.sendMessage(new Message(anna, List.of(may), "Yes, May! There's a cafe nearby with the best pancakes."));
        chatServer.sendMessage(new Message(anna, List.of(may), "Also, there's a new bakery we should try!"));
        chatServer.sendMessage(new Message(may, List.of(cece), "I found a great pizza spot, let’s all go!"));
        chatServer.sendMessage(new Message(cece, List.of(hera), "Count me in for pizza!"));
        chatServer.sendMessage(new Message(hera, List.of(cece), "Sounds good, CeCe!"));
        chatServer.sendMessage(new Message(hera, List.of(may), "May, let's plan for the Italian place next weekend."));
        chatServer.sendMessage(new Message(may, List.of(hera), "Absolutely, Hera! Can't wait."));
        System.out.println();

        System.out.println("===== Demonstrating Block Feature =====");
        System.out.println("Hera decides to block messages from May.");
        chatServer.blockMessages("Hera", "May");
        System.out.println();

        System.out.println("May tries to send a message to Hera after being blocked:");
        chatServer.sendMessage(new Message(may, List.of(hera), "Hera, I found a dessert place too!"));
        System.out.println();

        System.out.println("===== Demonstrating Unsent Feature =====");
        System.out.println("Anna unsent her last message to May.");
        chatServer.undoLastMessage(anna);
        System.out.printf("Now, Anna's last message is '%s'\n", anna.getChatHistory().getLastSentMessages());
        System.out.println();

        System.out.println("===== Demonstrating Iteration by Different Users =====");

        // Iterate over all messages involving May in Hera's chat history
        System.out.println("Iterating over all messages involving May in Hera's chat history:");
        Iterator<Message> iterator = hera.iterator(may);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        // Iterate over all messages involving Hera in CeCe's chat history
        System.out.println("Iterating over all messages involving Hera in CeCe's chat history:");
        iterator = cece.iterator(hera);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        // Iterate over all messages involving CeCe in May's chat history
        System.out.println("Iterating over all messages involving CeCe in May's chat history:");
        iterator = may.iterator(cece);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        // Iterate over all messages involving Anna in Hera's chat history
        System.out.println("Iterating over all messages involving Anna in May's chat history:");
        iterator = may.iterator(anna);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        System.out.println("===== User Unregistration =====");
        chatServer.unregisterUser(may);
        chatServer.sendMessage(new Message(hera, List.of(may), "Goodbye, May! Let’s try that restaurant next time."));
    }
}
