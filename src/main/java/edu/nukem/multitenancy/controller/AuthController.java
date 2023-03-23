package edu.nukem.multitenancy.controller;

import edu.nukem.multitenancy.dto.AuthDto;
import edu.nukem.multitenancy.entity.master.User;
import edu.nukem.multitenancy.service.TokenService;
import edu.nukem.multitenancy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody AuthDto authDto) {
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authDto.username(), authDto.password()));
        return tokenService.generateToken(authentication);

    }

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signUp(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }

}
