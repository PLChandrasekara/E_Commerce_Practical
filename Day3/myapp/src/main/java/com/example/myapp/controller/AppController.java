package com.example.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.model.Student;



@RestController
@RequestMapping("/app")

public class AppController {
	Student Bob = new Student("2020IT01","Bob Marley",23,"IT",3.2);
	Student Smith = new Student("2020IT02","Smith Harven",23,"IT",3.4);
	Student Lory = new Student("2020IT03","Lory Carmel",23,"IT",3.3);
	
	private static List<Student> students = new ArrayList<Student>();
	private Map<String,Student> mstudents=new HashMap<String,Student>();
	public AppController() {
		students.add(Bob);
		students.add(Smith);
		students.add(Lory);
		
		mstudents.put(Bob.getRegNo(),Bob);
		mstudents.put(Smith.getRegNo(),Smith);
		mstudents.put(Lory.getRegNo(),Lory);
		
	}
	@GetMapping("/msg")
	public String myMessage() {
		return "Hello Springboot";
	}
	@GetMapping("/name")
	public String myName() {
		return "My name is Springboot";
	}
	
	@GetMapping("/age/{ag}")
	public String myAge(@PathVariable("ag")int age) {
		return "My age is " + age;
	}
	
	@GetMapping("/course/{course}")
	public String myCourse(@PathVariable("course")String course) {
		return "My course is " + course;
	}
	
	//a method to return a student
	@GetMapping("/student")
	public Student getStudent() {
		return Bob;
	}
	//return multiple students
	@GetMapping("/students")
	public List<Student> getStudents(){
		students.add(Bob);
		students.add(Smith);
		students.add(Lory);
		return students;
	}
	
	//find a student from the list by regno
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id")String regno) {
		/*for(Student student:students) {
			if(student.getRegNo().equals(regno)) {
				return student;
			}
		}*/	
		return mstudents.get(regno);
		//return null;
	}
		//Add a new Student
		@PostMapping("/add")
		public String addStudent(@RequestBody Student student) {
			mstudents.put(student.getRegNo(), student);
			return "New Student Added";
		}
		
		//Delete the student
		@DeleteMapping("/Student/{id}")
		public String DeleteStudent(@PathVariable("id") String regno) {
			if(mstudents.get(regno) != null) {
				mstudents.remove(regno);
				return "The Student removed";
			}
			return "404 couldn't found the student";
		}
		//Update the student
		@PutMapping("/Student/{id}")
		public String updateStudent(@PathVariable("id") String regno,@RequestBody Student student) {
			if(mstudents.get(regno) != null) {
				mstudents.put(student.getRegNo(),student);
				return "The Student detailed are updates";
			}
			return "404 couldn't found the student";
		}


}
