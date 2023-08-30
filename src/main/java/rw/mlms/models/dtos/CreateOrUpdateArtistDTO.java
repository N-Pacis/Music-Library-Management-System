package rw.mlms.models.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateOrUpdateArtistDTO {

    @NotEmpty
    private String fullName;
}
