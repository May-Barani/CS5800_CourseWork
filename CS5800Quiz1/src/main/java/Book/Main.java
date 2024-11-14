package Book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        //Part 2: Testing BookShallowCopy
        List<String> chaptersShallow = new ArrayList<>();
        chaptersShallow.add("Contents");
        chaptersShallow.add("Getting Started");

        BookShallowCopy originalShallow = new BookShallowCopy("Java Basics", "Author N", chaptersShallow);
        BookShallowCopy cloneShallow = (BookShallowCopy) originalShallow.clone();

        //Modify the chapters of the original shallow copy book
        originalShallow.getChapters().add("Introduction");

        //Output results
        System.out.println("Original Shallow Copy Book: " + originalShallow);
        System.out.println("Cloned Shallow Copy Book: " + cloneShallow);
        System.out.println("\n----------------------------\n");

        //Part 3: Testing BookDeepCopy
        List<String> chaptersDeep = new ArrayList<>();
        chaptersDeep.add("Contents");
        chaptersDeep.add("Getting Started");

        BookDeepCopy originalDeep = new BookDeepCopy("Algorithm Design", "Author M", chaptersDeep);
        BookDeepCopy cloneDeep = (BookDeepCopy) originalDeep.clone();

        // Modify the chapters of the original deep copy book
        originalDeep.getChapters().add("Intro to Algorithms");

        //Output results
        System.out.println("Original Deep Copy Book: " + originalDeep);
        System.out.println("Cloned Deep Copy Book: " + cloneDeep);
    }
}
