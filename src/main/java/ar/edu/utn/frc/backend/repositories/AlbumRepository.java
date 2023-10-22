package ar.edu.utn.frc.backend.repositories;

import ar.edu.utn.frc.backend.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
