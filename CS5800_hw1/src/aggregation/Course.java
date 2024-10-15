package aggregation;

public class Course {
    private String courseName;
    Instructor instructor;
    Textbook textbook;

    public Course(String courseName, Instructor instructor, Textbook textbook) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.textbook = textbook;
    }

    public String getName() {
        return courseName;
    }

    public void setName(String courseName) {
        this.courseName = courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
    }

    public void print(){
        System.out.println("Course Name : " + this.courseName);
        System.out.println("Instructor : " + this.instructor.getFirstName() + ", " + this.instructor.getLastName());
        System.out.println("TextBook Title : " + this.textbook.getTitle());
        System.out.println("TextBook Author : " + this.textbook.getAuthor());
    }
    
    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName +
                ", instructor=" + instructor +
                ", textbook=" + textbook +
                '}';
    }
}