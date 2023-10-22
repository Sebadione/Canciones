package ar.edu.utn.frc.backend.application.controllers;

import ar.edu.utn.frc.backend.application.ResponseHandler;
import ar.edu.utn.frc.backend.application.response.TrackResponse;
import ar.edu.utn.frc.backend.services.TrackService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/tracks")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TrackController {

    TrackService trackService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val tracks = trackService.findAll()
                    .stream()
                    .map(TrackResponse::from)
                    .toList();
            return ResponseHandler.success(tracks);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

}
