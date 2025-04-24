package icet.edu.service;

import icet.edu.dto.VehicleAd;

import java.util.List;

public interface VehicalAdService {
    void saveCarAd(VehicleAd ad);
    VehicleAd getById(Long id);
    List<VehicleAd> getAll();
    void updateAd(Long id, VehicleAd updatedAd);
    void deleteAd(Long id);
}
