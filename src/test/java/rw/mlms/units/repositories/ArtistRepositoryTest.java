package rw.mlms.units.repositories;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import rw.mlms.models.Artist;
import rw.mlms.repositories.IArtistRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class ArtistRepositoryTest {

    @Mock
    private IArtistRepository artistRepository;

    @Test
    public void getAll() {
        // Mock the behavior of the artistRepository
        List<Artist> artists = Arrays.asList(new Artist(), new Artist());
        when(artistRepository.search(null)).thenReturn(artists);

        // Call the getAll() method
        List<Artist> actualArtists = artistRepository.search(null);

        // Assert that the expected results are returned
        assertEquals(artists, actualArtists);
    }

    @Test
    public void register() {
        // Mock the behavior of the artistRepository
        Artist artist = new Artist();
        when(artistRepository.save(any(Artist.class))).thenReturn(artist);

        // Call the register() method
        Artist actualArtist = artistRepository.save(artist);

        // Assert that the expected results are returned
        assertEquals(artist, actualArtist);
    }

    @Test
    public void update() {
        // Mock the behavior of the artistRepository
        Artist artist = new Artist();
        when(artistRepository.save(any(Artist.class))).thenReturn(artist);

        // Call the update() method
        Artist actualArtist = artistRepository.save(artist);

        // Assert that the expected results are returned
        assertEquals(artist, actualArtist);
    }

    @Test
    public void delete() {
        // Mock the behavior of the artistRepository
        Artist artist = new Artist();
        when(artistRepository.findById(UUID.randomUUID())).thenReturn(Optional.of(artist));

        // Call the delete() method
        artistRepository.delete(artist);

        // Assert that the expected results are returned
        verify(artistRepository).delete(artist);
    }
}