import java.util.ArrayList;

public class Courses {
    private ArrayList<String> num_of_courses = new ArrayList<>(5);

    public ArrayList<String> getNumOfCourses() {
        return num_of_courses;
    }

    public ArrayList<String> getCourses() {
        return num_of_courses;
    }
    
    public boolean addCourse(String courseName) {
        num_of_courses.add(courseName);
        
        if (num_of_courses.size() >= 5) {
            return false;
        }

        return true;
    }

    public boolean removeCourse(String courseName) {
        for(int i = 0; i < 5; i++) {
            if (num_of_courses.get(i).equalsIgnoreCase(courseName)) {
                num_of_courses.remove(i);
                
                return true;
            }
        }

        return false;
    }

}