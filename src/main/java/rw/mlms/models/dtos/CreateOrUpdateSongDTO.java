package rw.mlms.models.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Data
public class CreateOrUpdateSongDTO {

    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private Set<UUID> artists;
}
