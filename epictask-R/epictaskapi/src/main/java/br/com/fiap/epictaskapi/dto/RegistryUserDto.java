package br.com.fiap.epictaskapi.dto;

import br.com.fiap.epictaskapi.model.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegistryUserDto {

    @NotBlank(message = "Name is Mandatory")
    private String name;

    @Email(message = "Email is Mandatory")
    private String email;

    @NotBlank(message = "Password is Mandatory")
    private String password;

    public RegistryUserDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
}
