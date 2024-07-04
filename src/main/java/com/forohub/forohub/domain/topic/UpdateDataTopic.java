package com.forohub.forohub.domain.topic;

import jakarta.validation.constraints.NotBlank;

public record UpdateDataTopic(
       @NotBlank String title,
       @NotBlank String message
) {}

