import java.util.*;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Livan Jimenez 5540344
 */

public class Test {
    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        Admissions enrolledStudent = new Admissions();
        Admissions droppedStudent = new Admissions();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        Date date = new Date();

        while (true) {
            int optionMenu = GetData.getInt("\tFIU - Florida International University Student Registration Program\n"
                    + "\n" + "Enter a number to choose which option you'll like to take:" + "\n1.Enroll Student"
                    + "\n2.Drop Student" + "\n3.Add Course" + "\n4.Drop Course" + "\n5.Display current Information"
                    + "\n6.Exit");

            switch (optionMenu) {
            case 1:
                String firstName = GetData.getWord("Enter first name: ");
                String lastName = GetData.getWord("Enter last name: ");
                Name name = new Name(firstName, lastName);

                String street = GetData.getWord("Enter street: ");
                String state = GetData.getWord("Enter state: ");
                String city = GetData.getWord("Enter City ");
                String zip_code = GetData.getWord("Enter zip code: ");
                Address address = new Address(street, city, zip_code, state);

                String id_number = GetData.getWord("Enter student ID: ");
                String courseString = GetData.getWord("Enter course: ");

                Courses courses = new Courses();
                courses.addCourse(courseString);
                Student student = new Student(name, address, id_number, courses);

                enrolledStudent.addStudent(student);

                break;
            case 2:
                String idNumber = GetData.getWord("Enter Student ID number");
                enrolledStudent.search(idNumber);

                if (enrolledStudent.getLocation()) {
                    Student st = enrolledStudent.getStudent();
                    droppedStudent.addStudent(st);

                    int index = enrolledStudent.getIndex();
                    enrolledStudent.removeStudent(index);

                    JOptionPane.showMessageDialog(null, "The Student has been sucessfully removed");
                } else {
                    JOptionPane.showMessageDialog(null, "Student is not Registered");
                }

                break;
            case 3:
                id_number = GetData.getWord("Enter student ID: ");
                enrolledStudent.search(id_number);
                if (!enrolledStudent.getLocation()) {
                    JOptionPane.showMessageDialog(null, "ID NOT FOUND!");
                } else {
                    Courses initCourses = new Courses();
                    Student initStudent = enrolledStudent.getStudent();
                    addCourse(initStudent.getCourses());
                }

                break;
            case 4:
                id_number = GetData.getWord("Enter the Student ID number");
                enrolledStudent.search(id_number);
                if (enrolledStudent.getLocation()) {
                    Student st = enrolledStudent.getStudent();
                    String course = GetData.getWord("Enter course you want to drop");
                    if (st.removeCourse(course)) {
                        int index = enrolledStudent.getIndex();
                        st = enrolledStudent.getStudent();
                        JOptionPane.showMessageDialog(null, "The Course has been successfully deleted");
                    } else
                        JOptionPane.showMessageDialog(null, "You are not registered for thr Course");
                }
                break;
            case 5:
                int view = GetData.getInt(
                        "Choose between optioins 1 & 2:\n1.Currently Enrolled Students\n" + "2.Dropped Students");

                switch (view) {
                case 1:
                    ArrayList<Student> list = enrolledStudent.getList();
                    if (list.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "List is Empty");
                    } else {
                        int i = 0, length = enrolledStudent.getList().size();
                        String string = "";
                        String course = "";
                        while (i < length) {
                            Student student2 = (Student) list.get(i);
                            string += "ID Number:\t" + student2.getIdNumber() + "\nName\t:"
                                    + student2.getName().getFirstName() + " " + student2.getName().getLastName() + "\n"
                                    + "\nAddress:\t" + student2.getAddress().getStreet() + "\n\t"
                                    + student2.getAddress().getCity() + " " + student2.getAddress().getState() + ","
                                    + student2.getAddress().getZipCode() + "\nDate:\t" + student2.getDate()
                                    + "\nCourses:\t";
                            i++;
                            ArrayList<Student> courseList = student2.getCourses();

                            for (int j = 0; j < courseList.size(); j++) {
                                course = course + courseList.get(j) + " ";
                            }
                            display(string + course, "Student(s) enrolled:", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;

                case 2:
                    ArrayList droplist = dropStudent.getList();
                    String course = "";
                    if (droplist.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "List is Empty");
                    } else {
                        int i = 0, length = droplist.size();
                        String tr = "";
                        while (i < length) {
                            Student c = (Student) droplist.get(i);
                            tr = tr + "ID Number:\t" + c.getidno() + "\nName\t:" + c.getname().getfirstName() + " "
                                    + c.getname().getlastName() + "\n" + "\nAddress:\t" + c.getaddress().getstreet()
                                    + "\n\t" + c.getaddress().getcity() + " " + c.getaddress().getstate() + ","
                                    + c.getaddress().getzipcode() + "\nDate:\t" + c.getDate();
                            i++;
                        }
                        display(tr, "Dropped Students", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                
            case 6:
                break;
            default:
            }
        }
    }

    static void display(String s, String heading, int message_type) {
        JTextArea text = new JTextArea(s, 20, 30);
        JScrollPane pane = new JScrollPane(text);
        JOptionPane.showMessageDialog(null, text, heading, message_type);
    }

    static void addCourse(Courses crse) {
        boolean addAnotherCourse = true;
        while (addAnotherCourse) {
            int enter = GetData.getInt("Do you want to add course?\n1. Yes\n2. No");
            switch (enter) {
            case 1:
                String course = GetData.getWord("Enter name of course");
                if (!(crse.addCourse(course))) {
                    JOptionPane.showMessageDialog(null, "Can't add any more course Cousre Limit Reached");
                    addAnotherCourse = false;
                }
                break;
            case 2:
                addAnotherCourse = false;
                break;
            }
        }
    }
}