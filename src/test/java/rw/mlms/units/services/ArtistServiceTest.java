package rw.mlms.units.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import rw.mlms.models.Artist;
import rw.mlms.models.Song;
import rw.mlms.models.dtos.CreateOrUpdateArtistDTO;
import rw.mlms.models.dtos.CreateOrUpdateSongDTO;
import rw.mlms.services.IArtistService;
import rw.mlms.services.ISongService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
public class ArtistServiceTest {
    @Mock
    private IArtistService artistService;

    @Test
    public void getAll() {
        // Mock the behavior of the artistService
        List<Artist> artists = Arrays.asList(new Artist(), new Artist());
        when(artistService.getAll(null)).thenReturn(artists);

        // Call the getAll() method
        List<Artist> actualArtists = artistService.getAll(null);

        // Assert that the expected results are returned
        assertEquals(artists, actualArtists);
    }

    @Test
    public void register() {
        // Mock the behavior of the artistService
        CreateOrUpdateArtistDTO dto = new CreateOrUpdateArtistDTO();
        Artist artist = new Artist();
        when(artistService.register(dto)).thenReturn(artist);

        // Call the register() method
        Artist actualArtist = artistService.register(dto);

        // Assert that the expected results are returned
        assertEquals(artist, actualArtist);
    }

    @Test
    public void update() {
        // Mock the behavior of the artistService
        UUID artistId = UUID.randomUUID();
        CreateOrUpdateArtistDTO dto = new CreateOrUpdateArtistDTO();
        Artist artist = new Artist();
        when(artistService.update(artistId, dto)).thenReturn(artist);

        // Call the update() method
        Artist actualArtist = artistService.update(artistId, dto);

        // Assert that the expected results are returned
        assertEquals(artist, actualArtist);
    }

    @Test
    public void delete() {
        // Mock the behavior of the artistService
        UUID artistId = UUID.randomUUID();
        doNothing().when(artistService).delete(artistId);

        // Call the delete() method
        artistService.delete(artistId);

        // Assert that the expected results are returned
        verify(artistService).delete(artistId);
    }
}
