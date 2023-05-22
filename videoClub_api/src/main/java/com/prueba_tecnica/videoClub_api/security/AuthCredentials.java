package com.prueba_tecnica.videoClub_api.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;

}
