package ar.edu.utn.frc.backend.repositories;

import ar.edu.utn.frc.backend.models.Artist;
import ar.edu.utn.frc.backend.models.Genre;
import ar.edu.utn.frc.backend.models.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    List<Track> findAllByAlbum_ArtistAndGenre(Artist album_artist, Genre genre);
}
