package com.example.crud.controller;

import com.example.crud.model.dto.StudentDto;
import com.example.crud.service.student.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("student")
public class StudentController {

    private static final String CLASS_NAME = StudentController.class.getSimpleName();

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        log.info(CLASS_NAME);
        this.studentService = studentService;
    }

    @PostMapping("save")
    public void saveApi(@RequestBody StudentDto studentDto) {
        String methodName = CLASS_NAME + ".saveApi()";
        studentService.save(studentDto);
        log.info("{}, Successfully saved student into our transient DB: {}", methodName, studentDto);
    }

    @GetMapping("find/{id}")
    public StudentDto findByIdApi(@PathVariable String id) {
        String methodName = CLASS_NAME + ".findByIdApi()";
        log.info("{}, received uuid from path variable: {}", methodName, id);
        return studentService.findById(id);
    }

    @GetMapping("find")
    public List<StudentDto> findAllApi() {
        String methodName = CLASS_NAME + ".findAllApi()";
        log.info(methodName);
        return studentService.findAll();
    }

    @PutMapping("update/{id}")
    public void updateApi(@PathVariable String id, @RequestBody StudentDto studentDto) {
        String methodName = CLASS_NAME + ".updateApi()";
        studentService.update(id, studentDto);
        log.info("{}, Successfully updated student in our transient DB: {}", methodName, studentDto);
    }

    @DeleteMapping("delete")
    public void deleteApi(@RequestParam String id) {
        String methodName = CLASS_NAME + ".deleteApi()";
        log.info("{}, received id from request parameter: {}", methodName, id);
        studentService.remove(id);
        log.info("{}, Successfully deleted student into our transient DB: {}", methodName, id);
    }
}
