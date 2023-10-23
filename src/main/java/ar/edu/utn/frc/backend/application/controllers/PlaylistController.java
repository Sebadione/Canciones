package ar.edu.utn.frc.backend.application.controllers;

import ar.edu.utn.frc.backend.application.ResponseHandler;
import ar.edu.utn.frc.backend.application.request.CreatePlaylistRequest;
import ar.edu.utn.frc.backend.application.request.UpdatePlaylistRequest;
import ar.edu.utn.frc.backend.application.response.PlaylistResponse;
import ar.edu.utn.frc.backend.services.PlaylistService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/playlists")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PlaylistController {

    PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val playlists = playlistService.findAll()
                    .stream()
                    .map(PlaylistResponse::from)
                    .toList();
            return ResponseHandler.success(playlists);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Integer id) {
        try {
            return playlistService.findById(id)
                    .map(playlist -> ResponseHandler.success(PlaylistResponse.from(playlist)))
                    .orElseGet(ResponseHandler::notFound);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreatePlaylistRequest request) {
        try {
            val playlist = playlistService.create(request.getName());
            return ResponseHandler.success(playlist);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody UpdatePlaylistRequest request) {
        try {
            playlistService.update(id, request.getName());
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            playlistService.delete(id);
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            return ResponseHandler.noContent();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }


}
