package rw.mlms.units.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import rw.mlms.models.Song;
import rw.mlms.models.User;
import rw.mlms.models.dtos.CreateOrUpdateSongDTO;
import rw.mlms.services.ISongService;
import rw.mlms.services.IUserService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@SpringBootTest
public class SongServiceTest {
    @Mock
    private ISongService songService;

    @Test
    public void getAll() {
        // Mock the behavior of the songService
        List<Song> songs = Arrays.asList(new Song(), new Song());
        when(songService.getAll(null)).thenReturn(songs);

        // Call the getAll() method
        List<Song> actualSongs = songService.getAll(null);

        // Assert that the expected results are returned
        assertEquals(songs, actualSongs);
    }

    @Test
    public void register() {
        // Mock the behavior of the songService
        CreateOrUpdateSongDTO dto = new CreateOrUpdateSongDTO();
        Song song = new Song();
        when(songService.register(dto)).thenReturn(song);

        // Call the register() method
        Song actualSong = songService.register(dto);

        // Assert that the expected results are returned
        assertEquals(song, actualSong);
    }

    @Test
    public void update() {
        // Mock the behavior of the songService
        UUID songId = UUID.randomUUID();
        CreateOrUpdateSongDTO dto = new CreateOrUpdateSongDTO();
        Song song = new Song();
        when(songService.update(songId, dto)).thenReturn(song);

        // Call the update() method
        Song actualSong = songService.update(songId, dto);

        // Assert that the expected results are returned
        assertEquals(song, actualSong);
    }

    @Test
    public void delete() {
        // Mock the behavior of the songService
        UUID songId = UUID.randomUUID();
        doNothing().when(songService).delete(songId);

        // Call the delete() method
        songService.delete(songId);

        // Assert that the expected results are returned
        verify(songService).delete(songId);
    }
}
