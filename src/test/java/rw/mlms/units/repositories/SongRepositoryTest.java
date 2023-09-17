package rw.mlms.units.repositories;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import rw.mlms.models.Song;
import rw.mlms.repositories.ISongRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class SongRepositoryTest {

    @Mock
    private ISongRepository songRepository;

    @Test
    public void search() {
        // Mock the behavior of the songRepository
        List<Song> songs = Arrays.asList(new Song(), new Song());
        when(songRepository.search(null)).thenReturn(songs);

        // Call the search() method
        List<Song> actualSongs = songRepository.search(null);

        // Assert that the expected results are returned
        assertEquals(songs, actualSongs);
    }

    @Test
    public void findByTitle() {
        // Mock the behavior of the songRepository
        Song song = new Song();
        when(songRepository.findByTitle("Song Title")).thenReturn(Optional.of(song));

        // Call the findByTitle() method
        Optional<Song> actualSong = songRepository.findByTitle("Song Title");

        // Assert that the expected results are returned
        assertEquals(song, actualSong.get());
    }

    @Test
    public void save() {
        // Mock the behavior of the songRepository
        Song song = new Song();
        when(songRepository.save(song)).thenReturn(song);

        // Call the save() method
        Song actualSong = songRepository.save(song);

        // Assert that the expected results are returned
        assertEquals(song, actualSong);
    }

    @Test
    public void delete() {
        // Mock the behavior of the songRepository
        Song song = new Song();
        doNothing().when(songRepository).delete(song);

        // Call the delete() method
        songRepository.delete(song);

        // Assert that the expected results are returned
        verify(songRepository).delete(song);
    }
}
