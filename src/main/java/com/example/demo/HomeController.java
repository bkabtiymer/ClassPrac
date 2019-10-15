package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("classrooms", classroomRepository.findAll());
        return "index";
    }
//    public String homePage(Model model){
//        model.addAttribute("students", studentRepository.findAll());
//        model.addAttribute("classrooms",classroomRepository.findAll());
//        return "index";
//    }
//
    @RequestMapping("/studentlist")
        public String listStudent(Model model){
        model.addAttribute("students",studentRepository.findAll());
        return "studentlist";
    }
    @GetMapping("/addstudent")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("classrooms", new Classroom());
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

    @RequestMapping("/detailclass/{id}")
    public String showClassroom(@PathVariable("id") long id, Model model)
    {model.addAttribute("classroom", classroomRepository.findById(id).get());
        return "classroomshow";
    }
    @RequestMapping("/updateclass/{id}")
    public String updateClassroom(@PathVariable("id") long id,Model model){
        model.addAttribute("classroom", classroomRepository.findById(id).get());
        return "classroomform";
    }
    @RequestMapping("/deleteclass/{id}")
    public String delClassroom(@PathVariable("id") long id){
        classroomRepository.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/detailstudent/{id}")
    public String showStudent(@PathVariable("id") long id, Model model)
    {model.addAttribute("student", studentRepository.findById(id).get());
        return "studentshow";
    }
    @RequestMapping("/updatestudent/{id}")
    public String updateStudent(@PathVariable("id") long id,Model model){
        model.addAttribute("student", studentRepository.findById(id).get());
        model.addAttribute("classrooms", classroomRepository.findAll());
        return "employeeform";
    }
    @RequestMapping("/deletestudent/{id}")
    public String delStudent(@PathVariable("id") long id){
        studentRepository.deleteById(id);
        return "redirect:/";
    }
}
