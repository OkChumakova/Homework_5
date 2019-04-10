package homework_5;

import java.util.ArrayList;
import java.util.Collections;

public class Student implements Comparable <Student> {
    private String surname;
    private Integer course;
    private Integer studentAge;
    static ArrayList<Student> listOfStudents;

    public Student(String surname, int course, int studentAge) {
        this.surname = surname;
        this.course = course;
        this.studentAge = studentAge;
    }


    public int compareTo(Student o) {

        int result = this.surname.compareTo(o.surname);

        if (result == 0) {
            result = this.course.compareTo(o.course);
        }
        return result;
    }


    public static void getStudentsSorted(ArrayList<Student> listOfStudents){

        System.out.println("-------Before sorting--------");
        for (Student s : listOfStudents) {
            System.out.println(s);
        }
        System.out.println("\n -------After sorting-----");
        Collections.sort(listOfStudents);
        for (Student s : listOfStudents) {
            System.out.println(s);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "surname='" + surname + '\'' +
                ", course=" + course +
                ", studentAge='" + studentAge + '\'' +
                '}';
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }
}
