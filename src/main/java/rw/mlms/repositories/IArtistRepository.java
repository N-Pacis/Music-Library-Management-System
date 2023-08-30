package rw.mlms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rw.mlms.models.Artist;

import java.util.List;
import java.util.UUID;

@Repository
public interface IArtistRepository extends JpaRepository<Artist, UUID> {

    @Query("SELECT a FROM Artist a WHERE (:query IS NULL or LOWER(a.fullName) LIKE %:query%)")
    List<Artist> search(String query);
}
