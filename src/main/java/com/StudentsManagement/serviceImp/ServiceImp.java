package com.StudentsManagement.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentsManagement.entity.Student;
import com.StudentsManagement.repository.StudentRepository;
import com.StudentsManagement.service.StudentService;

@Service
public class ServiceImp implements StudentService{

	@Autowired
	private StudentRepository studentrepo;
	
	@Override
	public List<Student> getAllStudents() {
		
		return studentrepo.findAll();
	}
	@Override
	public Student saveStudent(Student student) {
		return studentrepo.save(student);
		
	}
	@Override
	public Student getById(int id) {
		return studentrepo.findById(id).get();
	
	}
	@Override
	public void deleteById(int id) {
		studentrepo.deleteById(id);
	}
	

}
