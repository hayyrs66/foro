package com.forohub.forohub.domain.course;

import jakarta.validation.constraints.NotBlank;

public record DataCourse(
    @NotBlank
    String name,
    @NotBlank
    String description
) {
}
