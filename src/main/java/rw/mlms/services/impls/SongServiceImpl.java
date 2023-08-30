package rw.mlms.services.impls;

import org.springframework.stereotype.Service;
import rw.mlms.exceptions.BadRequestException;
import rw.mlms.exceptions.ResourceNotFoundException;
import rw.mlms.models.Artist;
import rw.mlms.models.Song;
import rw.mlms.models.SongArtist;
import rw.mlms.models.User;
import rw.mlms.models.dtos.CreateOrUpdateSongDTO;
import rw.mlms.repositories.ISongArtistRepository;
import rw.mlms.repositories.ISongRepository;
import rw.mlms.services.IArtistService;
import rw.mlms.services.ISongService;
import rw.mlms.services.IUserService;

import java.util.*;

@Service
public class SongServiceImpl implements ISongService {

    private final ISongRepository songRepository;

    private final IUserService userService;

    private final IArtistService artistService;

    private final ISongArtistRepository songArtistRepository;

    public SongServiceImpl(ISongRepository songRepository, IUserService userService, IArtistService artistService, ISongArtistRepository songArtistRepository) {
        this.songRepository = songRepository;
        this.userService = userService;
        this.artistService = artistService;
        this.songArtistRepository = songArtistRepository;
    }

    @Override
    public List<Song> getAll(String searchQuery) {
        if(searchQuery != null) searchQuery = searchQuery.toLowerCase();
        return songRepository.search(searchQuery);
    }

    @Override
    public Song getById(UUID id){
        return songRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Song","id",id.toString()));
    }

    @Override
    public Song register(CreateOrUpdateSongDTO dto) {
        User user = userService.getLoggedInUser();
        Optional<Song> findByTitle = songRepository.findByTitle(dto.getTitle());
        if(findByTitle.isPresent())
            throw new BadRequestException(String.format("The song with title '%s' already exists",dto.getTitle()));

        Song song = new Song();
        song.setTitle(dto.getTitle());
        song.setAddedBy(user);


        song = songRepository.save(song);

        Set<SongArtist> songArtists = new HashSet<>();
        for(UUID artistId: dto.getArtists()){
            Artist artist = artistService.getById(artistId);
            SongArtist songArtist = new SongArtist();
            songArtist.setArtist(artist);
            songArtist.setSong(song);
            songArtists.add(songArtist);
        }
        songArtistRepository.saveAll(songArtists);

        return song;
    }

    @Override
    public Song update(UUID songId, CreateOrUpdateSongDTO dto) {
        Song song = getById(songId);
        if(!song.getTitle().equals(dto.getTitle())){
            Optional<Song> findByTitle = songRepository.findByTitle(dto.getTitle());
            if(findByTitle.isPresent())
                throw new BadRequestException(String.format("The song with title '%s' already exists",dto.getTitle()));

            song.setTitle(dto.getTitle());
        }

        Set<UUID> songArtistsIds = new HashSet<>();
        for(SongArtist songArtist: song.getSongArtists()){
            songArtistsIds.add(songArtist.getId());
        }

        if(!songArtistsIds.equals(dto.getArtists())){
            dto.getArtists().removeAll(songArtistsIds);
            Set<SongArtist> songArtists = new HashSet<>();
            for(UUID artistId: dto.getArtists()){
                Artist artist = artistService.getById(artistId);
                SongArtist songArtist = new SongArtist();
                songArtist.setArtist(artist);
                songArtist.setSong(song);
                songArtists.add(songArtist);
            }
            songArtistRepository.saveAll(songArtists);
        }

        return songRepository.save(song);
    }

    @Override
    public void delete(UUID songId) {
        Song song = getById(songId);
        songRepository.delete(song);
    }
}
