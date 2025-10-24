package com.StudentsManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentsManagement.entity.Student;
import com.StudentsManagement.repository.StudentRepository;
import com.StudentsManagement.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {


	@Autowired
	private StudentService studentservice;

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/studentsDetails")
	public String studentsDetails(Model model) {
		model.addAttribute("students" ,studentservice.getAllStudents());
		return "studentsDetails";
	}
	@GetMapping("/createform")
	public String createform(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "student_form";
	}
	
	@PostMapping("/savestd")
	public String savestd(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/studentsDetails";
	}
	@GetMapping("/edit/{id}")
	public String studentEdit(@PathVariable int id ,Model model) {
		model.addAttribute("student",studentservice.getById(id));
		return "edit";
	}
	@PostMapping("updateStudent/{id}")
	public String studentUpdate(@PathVariable int id,@ModelAttribute("student") Student student) {
		Student existingStudent = studentservice.getById(id);
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());
		
		studentservice.saveStudent(existingStudent);
		return "redirect:/studentsDetails";
	}
	@GetMapping("/delete/{id}")
	public String studentDelete(@PathVariable int id) {
		studentservice.deleteById(id);
		return "redirect:/studentsDetails";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
}
