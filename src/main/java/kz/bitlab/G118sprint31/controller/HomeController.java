package kz.bitlab.G118sprint31.controller;

import java.util.List;
import kz.bitlab.G118sprint31.db.DbManager;
import kz.bitlab.G118sprint31.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {
    List<Student> students = DbManager.getStudents();
    model.addAttribute("students", students);
    return "home";
  }

  @GetMapping("/add-student")
  public String addStudentPage() {
    return "addstudent";
  }

  @PostMapping("/add-student")
  public String addStudent(Student student) {
    DbManager.addStudent(student);
    return "redirect:/";
  }
}
