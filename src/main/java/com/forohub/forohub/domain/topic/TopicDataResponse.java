package com.forohub.forohub.domain.topic;

import com.forohub.forohub.domain.author.Author;
import com.forohub.forohub.domain.author.AuthorDataResponse;
import com.forohub.forohub.domain.course.Course;

import java.time.LocalDateTime;

public record TopicDataResponse(
        String title,
        String message,
        LocalDateTime date,
        AuthorDataResponse dataResponse,
        Course course
) {
}
