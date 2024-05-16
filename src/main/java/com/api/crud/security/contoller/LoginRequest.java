package com.api.crud.security.contoller;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    String nombreUsuario;
    String password;
}
