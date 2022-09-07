package com.cbnegociosinmobiliarios.propiedades.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbnegociosinmobiliarios.propiedades.model.LoginModel;
import com.cbnegociosinmobiliarios.propiedades.security.jwt.JwtTokenUtil;

@RestController
public class AuthApi {

    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request){
        try{
            Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(), request.getPassword()));

            LoginModel loginModel = (LoginModel) authentication.getPrincipal();
            String accessToken = jwtTokenUtil.GenerateAccessToken(loginModel);
            AuthResponse response = new AuthResponse(loginModel.getEmail(), accessToken);

            return ResponseEntity.ok().body(response);
            
        } catch (BadCredentialsException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
