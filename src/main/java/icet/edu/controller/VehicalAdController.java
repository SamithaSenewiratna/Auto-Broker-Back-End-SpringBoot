package icet.edu.controller;

import icet.edu.dto.VehicleAd;
import icet.edu.service.VehicalAdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car-ads")
@CrossOrigin
@RequiredArgsConstructor

public class VehicalAdController {

   final VehicalAdService service;

    @PostMapping("/add")
    public String create(@RequestBody VehicleAd vehicalAd) {
       service.saveCarAd(vehicalAd);
       return "add sucess";
    }


    @GetMapping("getById/{id}")
    public VehicleAd getById(@PathVariable Long id) {
        VehicleAd ad = service.getById(id);
        return ad ;
    }

    @GetMapping
    public List<VehicleAd> getAll() {
        return service.getAll();
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody VehicleAd updatedAd) {
        service.updateAd(id, updatedAd);
        return "Ad updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteAd(id);
        return "Ad deleted successfully";
    }

}
