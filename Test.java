import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Livan Jimenez 5540344
 */

public class Test {
    public static void main(String[] args) {
        new Test();
    }

    public void displayWindow(String str, String txtString, int JInfoMsg) {
        JTextArea text = new JTextArea(str, 20, 30);
        JOptionPane.showMessageDialog(null, text, txtString, JInfoMsg);
    }

    public void addCourse(Courses courses) {
        boolean adder = true;
        while (adder) {
            int newMenu = GetData.getInt("Do you want to add course?\n1.Yes\n2.No");

            switch (newMenu) {
            case 1:
                String course = GetData.getWord("Enter name of course");

                if (!(courses.addCourse(course))) {
                    JOptionPane.showMessageDialog(null, "Can't add any more course Cousre Limit Reached");
                    adder = false;
                }
                break;
            case 2:
                adder = false;
                break;
            }
        }
    }

    public Test() {
        Admissions enrolledStudent = new Admissions();
        Admissions droppedStudent = new Admissions();

        boolean start = false;

        while (!start) {
            int mainMenu = GetData.getInt("\tFIU - Florida International University Student Registration Program\n"
                    + "\n" + "Enter a number to choose which option you'll like to take:" + "\n1.Enroll Student"
                    + "\n2.Drop Student" + "\n3.Add Course" + "\n4.Drop Course" + "\n5.Display current Information"
                    + "\n6.Exit");

            switch (mainMenu) {
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
                Date newDate = new Date();
                Student student = new Student(name, address, id_number, courses, newDate);

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
                    Student initStudent = enrolledStudent.getStudent();
                    addCourse(initStudent.getCourses());
                }

                break;
            case 4:
                id_number = GetData.getWord("Enter the Student ID number");
                enrolledStudent.search(id_number);

                if (enrolledStudent.getLocation()) {
                    Student idStudent = enrolledStudent.getStudent();
                    String course = GetData.getWord("Enter course you want to drop");

                    if (idStudent.removeCourse(course)) {
                        idStudent = enrolledStudent.getStudent();
                        JOptionPane.showMessageDialog(null, "The Course has been successfully deleted.");
                    } else
                        JOptionPane.showMessageDialog(null, "Not registered for the course listed.");
                }
                break;
            case 5:
                int view = GetData.getInt(
                        "Choose between optioins 1 & 2:\n1.Currently Enrolled Students\n" + "2.Dropped Students");

                switch (view) {
                case 1:
                    ArrayList<Student> enrolledList = enrolledStudent.getList();
                    if (enrolledList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "null");
                    } else {
                        int i = 0, length = enrolledStudent.getList().size();

                        String string = "";
                        String course = "";

                        while (i < length) {
                            Student student2 = (Student) enrolledList.get(i);
                            string += "ID Number:\t" + student2.getIdNumber() + "\nName\t:"
                                    + student2.getName().getFirstName() + " " + student2.getName().getLastName() + "\n"
                                    + "\nAddress:\t" + student2.getAddress().getStreet() + "\n\t"
                                    + student2.getAddress().getCity() + " " + student2.getAddress().getState() + ","
                                    + student2.getAddress().getZipCode() + "\nDate:\t" + student2.getDate()
                                    + "\nCourses:\t";
                            i++;

                            ArrayList<String> courseList = student2.getCourseList();

                            for (int j = 0; j < courseList.size(); j++) {
                                course = course + courseList.get(j) + " ";
                            }
                            displayWindow(string + course, "Student(s) enrolled:", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;

                case 2:
                    ArrayList<Student> droppedList = droppedStudent.getList();

                    if (droppedList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "List is Empty");
                    } else {
                        int i = 0, length = droppedList.size();
                        String txt = "";

                        while (i < length) {
                            Student student3 = (Student) droppedList.get(i);
                            txt += "ID Number:\t" + student3.getIdNumber() + "\nName\t:"
                                    + student3.getName().getFirstName() + " " + student3.getName().getLastName() + "\n"
                                    + "\nAddress:\t" + student3.getAddress().getStreet() + "\n\t"
                                    + student3.getAddress().getCity() + " " + student3.getAddress().getState() + ","
                                    + student3.getAddress().getZipCode() + "\nDate:\t" + student3.getDate();
                            i++;
                        }
                        displayWindow(txt, "Dropped Students:", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                }

            case 6:
                start = true;
                break;
            default:
            }
        }
    }
}