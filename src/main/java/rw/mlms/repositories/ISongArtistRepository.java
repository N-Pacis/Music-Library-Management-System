package rw.mlms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.mlms.models.Song;
import rw.mlms.models.SongArtist;

import java.util.Set;
import java.util.UUID;

@Repository
public interface ISongArtistRepository extends JpaRepository<SongArtist, UUID> {

    Set<SongArtist> findBySong(Song song);
}
