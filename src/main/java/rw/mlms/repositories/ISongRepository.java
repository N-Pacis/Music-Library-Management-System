package rw.mlms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rw.mlms.models.Artist;
import rw.mlms.models.Song;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ISongRepository extends JpaRepository<Song, UUID> {

    @Query("SELECT s FROM Song s WHERE (:query IS NULL or LOWER(s.title) LIKE %:query%)")
    List<Song> search(String query);

    Optional<Song> findByTitle(String title);
}
