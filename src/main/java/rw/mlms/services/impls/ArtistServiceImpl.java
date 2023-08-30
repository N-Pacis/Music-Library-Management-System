package rw.mlms.services.impls;

import org.springframework.stereotype.Service;
import rw.mlms.exceptions.ResourceNotFoundException;
import rw.mlms.models.Artist;
import rw.mlms.models.User;
import rw.mlms.models.dtos.CreateOrUpdateArtistDTO;
import rw.mlms.repositories.IArtistRepository;
import rw.mlms.services.IArtistService;
import rw.mlms.services.IUserService;

import java.util.List;
import java.util.UUID;

@Service
public class ArtistServiceImpl implements IArtistService {

    private final IArtistRepository artistRepository;

    private final IUserService userService;

    public ArtistServiceImpl(IArtistRepository artistRepository, IUserService userService) {
        this.artistRepository = artistRepository;
        this.userService = userService;
    }

    @Override
    public List<Artist> getAll(String searchQuery) {
        if(searchQuery != null) searchQuery = searchQuery.toLowerCase();
        return artistRepository.search(searchQuery);
    }

    @Override
    public Artist getById(UUID id){
        return artistRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Artist","id",id.toString()));
    }

    @Override
    public Artist register(CreateOrUpdateArtistDTO dto) {

        Artist artist = new Artist();
        User user = userService.getLoggedInUser();
        artist.setFullName(dto.getFullName());
        artist.setRegisteredBy(user);

        return artistRepository.save(artist);
    }

    @Override
    public Artist update(UUID artistId, CreateOrUpdateArtistDTO dto) {
        Artist artist = getById(artistId);
        artist.setFullName(dto.getFullName());
        return artistRepository.save(artist);
    }

    @Override
    public void delete(UUID artistId) {
        Artist artist = getById(artistId);
        artistRepository.delete(artist);
    }
}
