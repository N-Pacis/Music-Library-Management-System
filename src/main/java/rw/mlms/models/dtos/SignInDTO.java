package rw.mlms.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class SignInDTO {

    @NotBlank
    private  String username;

    @NotBlank
    private  String password;
}

