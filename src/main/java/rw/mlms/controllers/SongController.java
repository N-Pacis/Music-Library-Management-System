package rw.mlms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.mlms.models.dtos.CreateOrUpdateSongDTO;
import rw.mlms.models.payload.ApiResponse;
import rw.mlms.services.ISongService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/songs")
public class SongController {

    private final ISongService songService;

    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll(
            @RequestParam(value = "query",required = false,defaultValue = "") String query
    ) {

        return ResponseEntity.ok(new ApiResponse(true, songService.getAll(query)));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody CreateOrUpdateSongDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, songService.register(dto)));
    }

    @PutMapping(path = "/{id}/update")
    public ResponseEntity<ApiResponse> update(
            @PathVariable(value = "id") UUID id,
            @Valid @RequestBody CreateOrUpdateSongDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, songService.update(id,dto)));
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<ApiResponse> delete(
            @PathVariable(value = "id") UUID id
    ) {
        this.songService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, null));
    }
}
