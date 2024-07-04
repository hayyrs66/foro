package com.forohub.forohub.controller;

import com.forohub.forohub.domain.course.Course;
import com.forohub.forohub.domain.course.CourseDataResponse;
import com.forohub.forohub.domain.course.CourseRepository;
import com.forohub.forohub.domain.course.DataCourse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<CourseDataResponse> addCourse(@RequestBody @Valid DataCourse data) {
        Course course = courseRepository.save(new Course(data));
        CourseDataResponse courseDataResponse = new CourseDataResponse(
                course.getName(),
                course.getDescription()
        );

        return ResponseEntity.ok(courseDataResponse);
    }
}
