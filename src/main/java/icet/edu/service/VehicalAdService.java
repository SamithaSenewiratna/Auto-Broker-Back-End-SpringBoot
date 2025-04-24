package icet.edu.service;

import icet.edu.dto.VehicalAd;

import java.util.List;

public interface VehicalAdService {
    void saveAd(VehicalAd ad);
    void updateAd(Long id, VehicalAd updatedAd);
    void deleteAd(Long id);
    VehicalAd getById(Long id);
    List<VehicalAd> getAll();
}
