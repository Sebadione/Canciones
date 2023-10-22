package ar.edu.utn.frc.backend.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Table(name = Album.TABLE_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Album {

    public static final String TABLE_NAME = "albums";

    @Id
    @Column(name = "albumId")
    Integer id;

    String title;

    @OneToOne
    @JoinColumn(name = "ArtistId")
    Artist artist;

    public Album(Integer id, String title, Artist artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public Album() {}

    public void update(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
    }
}
