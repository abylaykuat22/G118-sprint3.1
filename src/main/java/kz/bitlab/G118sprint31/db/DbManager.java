package kz.bitlab.G118sprint31.db;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.G118sprint31.model.Student;
import lombok.Getter;

public class DbManager {

  @Getter
  private static List<Student> students = new ArrayList<>();

  static {
    students.add(new Student(1L, "Alizhan", "Alizhan", 80, "B"));
    students.add(new Student(2L, "Elnur", "Elnur", 80, "B"));
    students.add(new Student(3L, "Student1", "Student1", 20, "F"));
  }

  private static Long id = 4L;

  private static void calculateMark(Student student) {
    var exam = student.getExam();
    if (exam == null) {
      return;
    }
    if (exam >= 90) {
      student.setMark("A");
    } else if (exam >= 75) {
      student.setMark("B");
    } else if (exam >= 60) {
      student.setMark("C");
    } else if (exam >= 50) {
      student.setMark("D");
    } else {
      student.setMark("F");
    }
  }

  public static void addStudent(Student student) {
    calculateMark(student);
    student.setId(id);
    students.add(student);
    id++;
  }
}
