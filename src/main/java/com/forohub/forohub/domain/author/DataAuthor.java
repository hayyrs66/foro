package com.forohub.forohub.domain.author;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataAuthor(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String username,
        @NotBlank
        String password

) {
}
