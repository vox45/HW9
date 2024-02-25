import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    int id;
    int age;
    List<Grade> grades;

    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grades = new ArrayList<>();
    }
}

class Grade {
    Student student;
    String subject;
    double grade;

    public Grade(Student student, String subject, double grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }
}

class StudentManager {
    List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addGrade(int studentId, String subject, double grade) {
        for (Student student : students) {
            if (student.id == studentId) {
                Grade newGrade = new Grade(student, subject, grade);
                student.grades.add(newGrade);
                break;
            }
        }
    }

    public double getAverageGrade(int studentId) {
        for (Student student : students) {
            if (student.id == studentId) {
                if (student.grades.isEmpty()) {
                    return 0;  // No grades available
                }
                double totalGrades = 0;
                for (Grade grade : student.grades) {
                    totalGrades += grade.grade;
                }
                return totalGrades / student.grades.size();
            }
        }
        return 0;  // Student not found
    }
}

public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкти студентів
        Student student1 = new Student("John Doe", 1, 20);
        Student student2 = new Student("Jane Smith", 2, 22);

        // Створюємо об'єкт менеджера студентів
        StudentManager studentManager = new StudentManager();

        // Додаємо студентів до списку
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);

        // Додаємо оцінки для студентів
        studentManager.addGrade(1, "Math", 90);
        studentManager.addGrade(1, "Physics", 85);
        studentManager.addGrade(2, "Math", 92);
        studentManager.addGrade(2, "Physics", 88);

        // Виводимо середній бал кожного студента
        for (Student student : studentManager.students) {
            double averageGrade = studentManager.getAverageGrade(student.id);
            System.out.println(student.name + "'s average grade: " + averageGrade);
        }
    }
}
