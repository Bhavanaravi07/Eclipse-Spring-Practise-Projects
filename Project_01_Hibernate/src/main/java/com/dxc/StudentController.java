package com.dxc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dxc.model.Student;
import com.dxc.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;

	@Autowired(required = true)
	@Qualifier(value = "studentService")
	public void setStudentService(StudentService ss) {
		this.studentService = ss;
	}
	
	@RequestMapping(value = "/Student", method = RequestMethod.GET)
	public String listStudents(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("listStudents", this.studentService.listStudents());
		return "student";
	}
	
	//For add and update student both
		@RequestMapping(value= "/student/add", method = RequestMethod.POST)
		public String add(@ModelAttribute("Student") Student s){
			
			if(s.getStudentid() == 0){
				//new student, add it
				this.studentService.add(s);
			}else{
				//existing student, call update
				this.studentService.update(s);
			}
			
			return "redirect:/students";
			
		}
		
		@RequestMapping("/remove/{id}")
	    public String remove(@PathVariable("id") int id){
			
	        this.studentService.delete(id);
	        return "redirect:/students";
	    }
		
		@RequestMapping("/edit/{id}")
	    public String edit(@PathVariable("id") int id, Model model){
	        model.addAttribute("student", this.studentService.getStudentById(id));
	        model.addAttribute("listStudents", this.studentService.listStudents());
	        return "student";
	    }
	 
		

}
