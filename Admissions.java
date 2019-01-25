import java.util.ArrayList;

public class Admissions {
    private Student student;
    private int index;
    private boolean location;
    private Courses courses;

    private ArrayList<Student> list = new ArrayList<>();

    public Admissions() {
        list = new ArrayList<Student>();
    }

    public Student getStudent() {
        return student;
    }

    public int getIndex() {
        return index;
    }

    public boolean getLocation() {
        return location;
    }

    public Courses getCourses() {
        return courses;
    }

    public void addStudent(Student student) {
        list.add(student);
    }

    public void removeStudent(Student student) {
        list.remove(student);
    }

    public Student search(String studentID) {
        location = false;
        index = 0;

        int sizeOfList = list.size();
        if (index < sizeOfList && !location) {
            student = list.get(index);

            if (student.getIdNumber().compareTo(studentID) == 0) {
                location = true;
            } else {
                index++;
            }
        }

        return null;
    }
}