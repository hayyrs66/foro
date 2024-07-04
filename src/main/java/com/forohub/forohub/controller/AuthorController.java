package com.forohub.forohub.controller;

import com.forohub.forohub.domain.author.Author;
import com.forohub.forohub.domain.author.DataAuthor;
import com.forohub.forohub.domain.infra.security.DataJWTToken;
import com.forohub.forohub.domain.infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")

public class AuthorController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity addAuthor(@RequestBody @Valid DataAuthor data) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generateToken((Author) authenticatedUser.getPrincipal());
        return ResponseEntity.ok().body(new DataJWTToken(JWTtoken));
    }
}
