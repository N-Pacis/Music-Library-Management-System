package rw.mlms.models.dtos;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignInDTO {

    @NotBlank
    private  String username;

    @NotBlank
    private  String password;
}

