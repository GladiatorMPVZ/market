package shopcore.controller;

import api.JwtRequest;
import api.JwtResponse;
import api.StringResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import shopcore.utils.JwtService;

import java.security.Principal;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/api/v1/auth")
    public JwtResponse authorize(@RequestBody JwtRequest request) {
        log.info("Auth request: [{}, {}]", request.getUsername(), request.getPassword());
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            UserDetails user = (UserDetails) authenticate.getPrincipal();
            String jwtToken = jwtService.generateJwtToken(user);
            return new JwtResponse(jwtToken);
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    @GetMapping("/auth_check")
    public StringResponse authCheck(Principal principal) {
        return new StringResponse(principal.getName());
    }
}
