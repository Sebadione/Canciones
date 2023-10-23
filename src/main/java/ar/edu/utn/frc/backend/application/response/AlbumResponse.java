package ar.edu.utn.frc.backend.application.response;

import ar.edu.utn.frc.backend.models.Album;
import ar.edu.utn.frc.backend.models.Playlist;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlbumResponse {

    Integer id;

    String title;

    String artistName;

    public static AlbumResponse from(Album album) {
        return AlbumResponse.builder()
                .id(album.getId())
                .title(album.getTitle())
                .artistName(album.getArtist().getName())
                .build();
    }
}
