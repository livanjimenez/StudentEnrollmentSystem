import java.util.*;
import java.text.DateFormat;

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
                currentlyEnrolled.search(idNumber);
                if (currentlyEnrolled.inList()) {
                    Student st = currentlyEnrolled.getstudent();
                    dropStudent.addStudent(st);
                    int index = currentlyEnrolled.getindex();
                    currentlyEnrolled.removeStudent(index);
                    JOptionPane.showMessageDialog(null, "The Student has Sucessfully removed");
                } else {
                    JOptionPane.showMessageDialog(null, "Student is not Registered");
                }
                break;
            case 3:
                id = GetData.getWord("Enter the Student ID number");
                currentlyEnrolled.search(id);
                if (!currentlyEnrolled.inList()) {
                    JOptionPane.showMessageDialog(null, "Id not found");
                } else {
                    Courses crose = new Courses();
                    Student newStudent = currentlyEnrolled.getstudent();
                    addCourse(newStudent.courses);
                }
                break;
            case 4:
                id = GetData.getWord("Enter the Student ID number");
                currentlyEnrolled.search(id);
                if (currentlyEnrolled.inList()) {
                    Student st = currentlyEnrolled.getstudent();
                    String course = GetData.getWord("Enter course you want to drop");
                    if (st.dropcourses(course)) {
                        int index = currentlyEnrolled.getindex();
                        st = currentlyEnrolled.getstudent();
                        JOptionPane.showMessageDialog(null, "The Course has been successfully deleted");
                    } else
                        JOptionPane.showMessageDialog(null, "You are not registered for thr Course");
                }
                break;
            case 5:
                int view = GetData.getInt("What information would youlike to view?\n1.Currently Enrolled Students\n"
                        + "2.Dropped Students");
                switch (view) {
                case 1:// view currently Enrolled Students
                    ArrayList list = currentlyEnrolled.getList();
                    if (list.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "List is Empty");
                    } else {
                        int i = 0, length = currentlyEnrolled.size();
                        String st = "";
                        String course = "";
                        while (i < length) {
                            Student stud = (Student) list.get(i);
                            st = st + "ID Number:\t" + stud.getidno() + "\nName\t:" + stud.getname().getfirstName()
                                    + " " + stud.getname().getlastName() + "\n" + "\nAddress:\t"
                                    + stud.getaddress().getstreet() + "\n\t" + stud.getaddress().getcity() + " "
                                    + stud.getaddress().getstate() + "," + stud.getaddress().getzipcode() + "\nDate:\t"
                                    + stud.getDate() + "\nCourses:\t";
                            i++;
                            ArrayList courseList = stud.getCourses();

                            for (int j = 0; j < courseList.size(); j++) {
                                course = course + courseList.get(j) + " ";
                            }
                            display(st + course, "Currently Enrolled", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;
                case 6:
                    break;
                default:
                }
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
                if (!(crse.addcourses(course))) {
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