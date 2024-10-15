package aggregation;

public class CourseDriver {

    public static void main(String[] args) {

        Instructor instructor = new Instructor("Nima","Davarpanah ","3-2636");
        Textbook textbook = new Textbook("Clean Code ","Robert C Martin","Prentice Hall");
        Course course = new Course("CS5800-Advanced Software Engineering",instructor,textbook);

        //System.out.println(course);

        course.print();
        System.out.println("-----------------------------------------------------------------------------------");
        /// Modified course object
        Instructor instructor1 = new Instructor("Gilbert", "Young", "3-2636");
        Instructor instructor2 = new Instructor("John", "Korah", "2-2636");

        Textbook textBook1 = new Textbook("Horowitz, Sahni and Rajasekaran", "Computer Algorithms", "Pseudocode version");
        Textbook textBook2 = new Textbook("Grama, G. Karypis, V. Kumara and A. Gupta", "Introduction to Parallel Computing", "2nd edition");

        SecondCourse SecondCourse = new SecondCourse("Advanced Algorithms Courses");

        try{
            SecondCourse.addInstructor(instructor1);
            SecondCourse.addInstructor(instructor2);

            SecondCourse.addTextBook(textBook1);
            SecondCourse.addTextBook(textBook2);

            SecondCourse.print();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}


