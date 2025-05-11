package icet.edu.controller;

import icet.edu.dto.SparePartAd;
import icet.edu.service.SparePartAdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sparepart")
@RequiredArgsConstructor
public class SparePartAdController {

    private final SparePartAdService service;

    @PostMapping
    public ResponseEntity<Void> addSparePartAd(@RequestBody SparePartAd ad) {
        service.saveAd(ad);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSparePartAd(@PathVariable Long id, @RequestBody SparePartAd updatedAd) {
        updatedAd.setId(id);
        service.updateAd(id, updatedAd);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSparePartAd(@PathVariable Long id) {
        service.deleteAd(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SparePartAd> getSparePartAdById(@PathVariable Long id) {
        SparePartAd ad = service.getById(id);
        return ResponseEntity.ok(ad);
    }

    @GetMapping
    public ResponseEntity<List<SparePartAd>> getAllSparePartAds() {
        List<SparePartAd> ads = service.getAll();
        return ResponseEntity.ok(ads);
    }
}
