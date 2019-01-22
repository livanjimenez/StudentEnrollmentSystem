import java.util.*;

public class Student {
    private Name name;
    private Address address;
    private int id_number;
    private String[] courses;
    private Date date;

    public Student(Name name, Address address, int id_number, String[] courses, Date date) {
        this.name = name;
        this.address = address;
        this.id_number = id_number;
        this.courses = courses;
    }

    public Student() {
        // Test constructor
        name = new Name();
        address = new Address();
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public int getIdNumber() {
        return id_number;
    }

    public String getCourses() {
        String myCourse = "";
        for (String arr : courses) {
            if (arr == null)
                break;
            myCourse = myCourse + arr + " ";
        }

        return myCourse; // refactor getter for array of courses
    }

    public Date getDate() {
        return date;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setIdNumber(int id_number) {
        this.id_number = id_number;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public String toString() {
        return "Id number: " + id_number + "\n" + name + "\n" + address + "\n" + "Date: " + date + "\n" + "Courses: \n"
                + getCourses();
    }
}