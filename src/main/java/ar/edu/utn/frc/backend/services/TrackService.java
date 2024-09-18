package ar.edu.utn.frc.backend.services;



import ar.edu.utn.frc.backend.models.Album;
import ar.edu.utn.frc.backend.models.Artist;
import ar.edu.utn.frc.backend.models.Genre;
import ar.edu.utn.frc.backend.models.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    List<Track> findAll();

    Optional<Track> findById(final Integer id);

    List<Track> findAllByAlbum_ArtistAndGenre(int artistId, int genreId);

    Track create(String name, int albumId, int mediaTypeId, int genreId,
                 String composer, int milliseconds, int bytes, double unitPrice);

    void delete(final Integer id);
    void update(Integer id, String name, int albumId, int mediaTypeId, int genreId,
                String composer, int milliseconds, int bytes, double unitPrice);

}
