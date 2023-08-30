package rw.mlms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.mlms.models.dtos.CreateOrUpdateArtistDTO;
import rw.mlms.models.payload.ApiResponse;
import rw.mlms.services.IArtistService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/artists")
public class ArtistController {

    private final IArtistService artistService;

    public ArtistController(IArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll(
            @RequestParam(value = "query",required = false,defaultValue = "") String query
    ) {

        return ResponseEntity.ok(new ApiResponse(true, artistService.getAll(query)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(
            @PathVariable(value = "id") UUID id
    ) {

        return ResponseEntity.ok(new ApiResponse(true, artistService.getById(id)));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody CreateOrUpdateArtistDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, artistService.register(dto)));
    }

    @PutMapping(path = "/{id}/update")
    public ResponseEntity<ApiResponse> update(
            @PathVariable(value = "id") UUID id,
            @Valid @RequestBody CreateOrUpdateArtistDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, artistService.update(id,dto)));
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<ApiResponse> delete(
            @PathVariable(value = "id") UUID id
    ) {
        this.artistService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, null));
    }
}
