package com.forohub.forohub.controller;

import com.forohub.forohub.domain.author.Author;
import com.forohub.forohub.domain.author.AuthorDataResponse;
import com.forohub.forohub.domain.author.AuthorRepository;
import com.forohub.forohub.domain.course.Course;
import com.forohub.forohub.domain.course.CourseRepository;
import com.forohub.forohub.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<TopicDataResponse> addTopic(@RequestBody @Valid DataTopic data, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicRepository.save(new Topic(data));
        Author author = authorRepository.getReferenceById(data.idAuthor());
        AuthorDataResponse authorDataResponse = new AuthorDataResponse(author.getName(), author.getUsername());
        Course course = courseRepository.getReferenceById(data.idCourse());

        TopicDataResponse topicDataResponse = new TopicDataResponse(
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                authorDataResponse,
                course
        );

        URI uri = uriComponentsBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(topicDataResponse);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDataResponse>> getTopics(@PageableDefault(size = 10) Pageable pagination) {
        Page<Topic> topicsPage = topicRepository.findAll(pagination);
        Page<TopicDataResponse> responsePage = topicsPage.map(topic -> {
            Author author = authorRepository.getReferenceById(topic.getIdAuthor());
            Course course = courseRepository.getReferenceById(topic.getIdCourse());
            AuthorDataResponse authorDataResponse = new AuthorDataResponse(author.getName(), author.getUsername());

            return new TopicDataResponse(topic.getTitle(), topic.getMessage(), topic.getCreationDate(), authorDataResponse, course);
        });
        return ResponseEntity.ok(responsePage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDataResponse> getTopic(@PathVariable Long id) {

        if(!topicRepository.existsById(id)) {
            throw new ValidationException("NO existe ese post");
        }
            Topic topic = topicRepository.getReferenceById(id);
            Author author = authorRepository.getReferenceById(topic.getIdAuthor());
            Course course = courseRepository.getReferenceById(topic.getIdCourse());
            AuthorDataResponse authorDataResponse = new AuthorDataResponse(author.getName(), author.getUsername());

            TopicDataResponse topicDataResponse = new TopicDataResponse(topic.getTitle(), topic.getMessage(), topic.getCreationDate(), authorDataResponse, course);

            return ResponseEntity.ok(topicDataResponse);
    }

    @PutMapping("/{id}")
    @Transactional
    public void updateTopic(@PathVariable Long id, @RequestBody UpdateDataTopic data){
        Topic topic = topicRepository.getReferenceById(id);
        topic.updateData(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteTopic(@PathVariable Long id){
        Topic topic = topicRepository.getReferenceById(id);
        topicRepository.delete(topic);
    }
}
