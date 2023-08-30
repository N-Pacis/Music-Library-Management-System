package rw.mlms.services;

import rw.mlms.models.Song;
import rw.mlms.models.dtos.CreateOrUpdateSongDTO;

import java.util.List;
import java.util.UUID;

public interface ISongService {

    List<Song> getAll(String searchQuery);

    Song getById(UUID id);

    Song register(CreateOrUpdateSongDTO dto);

    Song update(UUID songId, CreateOrUpdateSongDTO dto);

    void delete(UUID songId);
}
