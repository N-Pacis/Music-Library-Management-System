package rw.mlms.services;

import rw.mlms.models.Artist;
import rw.mlms.models.dtos.CreateOrUpdateArtistDTO;

import java.util.List;
import java.util.UUID;

public interface IArtistService {

    List<Artist> getAll(String searchQuery);

    Artist getById(UUID id);

    Artist register(CreateOrUpdateArtistDTO dto);

    Artist update(UUID artistId, CreateOrUpdateArtistDTO dto);

    void delete(UUID artistId);
}
