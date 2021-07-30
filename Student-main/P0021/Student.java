package P0021;

public class Student {
    private String id;
    private String name;
    private int semester;
    private String courseName;


    public Student(String id, String name, int semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String stname) {
        this.name = stname;
    }


    public int getSemester() {
        return semester;
    }


    public void setSemester(int semester) {
        this.semester = semester;
    }


    public String getCourseName() {
        return courseName;
    }


    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }





    

}
