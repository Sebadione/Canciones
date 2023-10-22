package ar.edu.utn.frc.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = Playlist.TABLE_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Playlist {

    public static final String TABLE_NAME = "playlists";
    @Id
    @Column(name = "PlaylistId")
    Integer id;

    String name;

    @ManyToMany(mappedBy = "playlists")
    List<Track> tracks;

    public Playlist(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Playlist() {
    }

    public void update(String name) {
        this.name = name;
    }
}
