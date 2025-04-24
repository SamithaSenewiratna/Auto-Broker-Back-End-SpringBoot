package icet.edu.service;

import icet.edu.dto.SparePartAd;

import java.util.List;

public interface SparePartAdService {

    void saveAd(SparePartAd ad);

    void deleteAd(Long id);

    SparePartAd getById(Long id);

    List<SparePartAd> getAll();

    void updateAd(Long id, SparePartAd updatedAd);
}
