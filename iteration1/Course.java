import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



// Course class
class Course {
    private String courseCode;
    private String courseName;
    private int courseCredit;
    private Grade grade;
    private Lecturer lecturer;

    // Constructor
    public Course(String courseCode, String courseName, int courseCredit,Lecturer lecturer) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseCredit = courseCredit;
        this.lecturer=lecturer;
        this.grade = new Grade();
    }

    public boolean checkYearMatching(int Year){
        return false;
    }

    public boolean checkCourseSection(List<Course> registrationCompleteCourse, List<Course> registrationWaitingCourse, List<Course> cancelWaitingCourse){
        return false;
    }

    public boolean checkPreRequisite(){
        return false;
    }

    public String getCourseString(){
        return 0;
    }

    public String getCourseTranscriptFormatString(){
        return 0;
    }

    public int getCourseCredit() {
        return courseCredit;
    }
}
