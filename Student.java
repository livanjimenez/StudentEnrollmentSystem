import java.text.DateFormat;
import java.util.*;

public class Student {
    private Name name;
    private Address address;
    private String id_number;
    private Courses courses;
    private String date;
    private Date newDate;

    private DateFormat df = DateFormat.getDateInstance();

    public Student(Name name, Address address, String id_number, Courses courses, Date newDate) {
        this.name = name;
        this.address = address;
        this.id_number = id_number;
        this.courses = courses;
        date = df.format(new Date());
        this.newDate = newDate;
    }

    public ArrayList<String> getCourseList() {
        return courses.getCourses();
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getIdNumber() {
        return id_number;
    }

    public Courses getCourses() {
        return courses;
    }

    public String getDate() {
        return date;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setIdNumber(String id_number) {
        this.id_number = id_number;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public boolean addCourses(String course) {
        return courses.addCourse(course);
    }

    public boolean removeCourse(String course) {
        return courses.removeCourse(course);
    }

    public String toString() {
        return "Id number: " + id_number + "\n" + name + "\n" + 
            address + "\n" + "Date: " + date + "\n" + "Courses: \n" + getCourses();
    }
}