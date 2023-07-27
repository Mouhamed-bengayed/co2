package com.example.co2.dtos;

//import antlr.Token;

import lombok.Data;
import org.antlr.v4.runtime.*;

@Data
public class JwtResponse {
    private Token token;

    public JwtResponse(String token) {
    }
}
