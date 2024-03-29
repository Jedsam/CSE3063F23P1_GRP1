import java.util.ArrayList;
import java.util.List;


// Course class
class Course {
    private final String courseCode;


    private final String courseName;
    private final int courseCredit;

    public int getCourseYear() {
        return courseYear;
    }

    private final int courseYear;
    private final CourseSection section;
    //private Grade grade;
    private Lecturer lecturer;
    private List<Course> preRequisite;

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public List<Course> getPreRequisite() {
        return preRequisite;
    }

    public void setPreRequisite(List<Course> preRequisite) {
        this.preRequisite = preRequisite;
    }

    // Constructor
    public Course(String courseCode, String courseName, int courseCredit, int courseYear, int section1, int section2, Lecturer lecturer, List<Course> preRequisite) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseCredit = courseCredit;
        this.courseYear = courseYear;
        this.section = new CourseSection(section1, section2);
        this.lecturer = lecturer;
        this.preRequisite = preRequisite;
    }

    // Check if this student in the appropriate semester to take this course?
    public boolean checkYearMatching(int year) {
        return courseYear <= year;
    }

    // Check if this course conflicts with any other courses section returns 0 for available course
    public String checkCourseSection(List<Course> registrationCompleteCourses, List<Course> registrationWaitingCourses, List<Course> cancelWaitingCourses) {
        for (Course course : registrationCompleteCourses) {
            if (this.equals(course)) {
                return "This course:(" + course.toString() + ")" + "already exist in completedRegistrationCourses.Try to select another course";
            }
            if (!course.getSection().compareAvailability(this.section)) {
                return "This course is conflicting with the time of the course : " + course.toString() + " inside your courses that are registered!";
            }
        }
        for (Course course : registrationWaitingCourses) {
            if (this.equals(course)) {
                return "This course:(" + course.toString() + ")" + " already exist in registrationWaitingCourses.Try to select another course";
            }
            if (!course.getSection().compareAvailability(this.section)) {
                return "This course is conflicting with the time of the course : " + course.toString() + " inside your courses that are waiting to be registered!";
            }
        }
        for (Course course : cancelWaitingCourses) {
            if (this.equals(course)) {
                return "This course:(" + course.toString() + ")" + " already exist in cancelWaitingCourses.Try to select another course";
            }
            if (!course.getSection().compareAvailability(this.section)) {
                return "This course is conflicting with the time of the course : " + course.toString() + " inside your courses that are waiting to be canceled!";
            }
        }
        return null;
    }
    
    
    public boolean equals(Course course2){
        return course2 != null && this.courseName.equals(course2.getCourseName());
    }

    // Check if given student can take this course, according to prerequisite and given completed courses
    public boolean checkPreRequisite(List<Course> completedCourses, List<Grade> gradeList) {
        if (preRequisite == null) {
            return true;
        }
        if (preRequisite.isEmpty()) {
            return true;
        }
        List<Course> copy = new ArrayList<>(preRequisite);

        for (Course course : completedCourses) {
            for (int i = 0; i < copy.size(); i++) {
                Course preRequisiteCurrent = copy.get(i);
                if (course.equals(preRequisiteCurrent) && gradeList.get(i).isPassedGrade()) {
                    copy.remove(preRequisiteCurrent);
                }
            }
            if (copy.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    // Returns course information, code and 
    @Override
    public String toString() {
        return courseCode + " " + courseName;
    }

    public String toStringFormatted(int format) {
        if (format == 1) {
            return courseCode + " " + courseName;
        } else {
            return courseCode + " " + courseName + " " + this.lecturer.toString();
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public CourseSection getSection() {
        return section;
    }

    public String getCourseName() {
        return courseName;
    }

}
