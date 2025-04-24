package icet.edu.controller;

import icet.edu.dto.VehicalAd;
import icet.edu.service.VehicalAdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car-ads")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class VehicalAdController {

    private final VehicalAdService service;

    @PostMapping("/add")
    public String create(@RequestBody VehicalAd ad) {
        service.saveAd(ad);
        return "Ad added successfully";
    }

    @GetMapping("/{id}")
    public VehicalAd getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<VehicalAd> getAll() {
        return service.getAll();
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody VehicalAd updatedAd) {
        service.updateAd(id, updatedAd);
        return "Ad updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteAd(id);
        return "Ad deleted successfully";
    }
}
