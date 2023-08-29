package rw.mlms.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rw.mlms.config.security.ValidPassword;

import javax.validation.constraints.NotBlank;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

    private  String username;

    @NotBlank
    private  String fullName;

    @ValidPassword
    private  String password;
}
