package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @RequestMapping("/")
    public String homePage(Model model){
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("classrooms",classroomRepository.findAll());
        return "index";
    }
    @RequestMapping("/studentlist")
        public String listStudent(Model model){
        model.addAttribute("students",studentRepository.findAll());
        return "studentlist";
    }
    @GetMapping("/addstudent")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
                return "studentform";
    }
    @PostMapping("/processstudent")
    public String processStudent(@Valid Student student, BindingResult result){
        if (result.hasErrors()){
            return "studentform";
        }
        studentRepository.save(student);
        return "redirect:/studentlist";
    }

    @RequestMapping("/classroomlist")
    public String listClassroom(Model model){
        model.addAttribute("classrooms",classroomRepository.findAll());
        return "classroomlist";
    }
    @GetMapping("/addclassroom")
    public String addClassrooms(Model model){
        model.addAttribute("classroom", new Classroom());
        return "classroomform";
    }
    @PostMapping("/processclassroom")
    public String processClassroom(@Valid Classroom classroom, BindingResult result){
        if (result.hasErrors()){
            return "classroomform";
        }
        classroomRepository.save(classroom);
        return "redirect:/classroomlist";
    }
}
