package com.api.crud.security.contoller;

import com.api.crud.security.models.RolNombre;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String nombreUsuario;
    private String password;
    private String email;
    private String nombre;
    private String apellidos;
    private RolNombre rol;
}
