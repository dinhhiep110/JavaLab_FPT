package P0021;

public class Report {
    private String studentName;
    private String course;
    private int totalCourse;

    public Report(String studentName, String course, int totalCourse) {
        this.studentName = studentName;
        this.course = course;
        this.totalCourse = totalCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public void display(){
        System.out.printf("%-20s|%-30s|%-12s|\n", studentName, course, totalCourse);
    }

}
