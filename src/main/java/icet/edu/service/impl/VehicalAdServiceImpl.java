
package icet.edu.service.impl;

import icet.edu.dto.VehicalAd;
import icet.edu.entity.VehicalAdEntity;
import icet.edu.repository.VehicalAdRepository;
import icet.edu.service.VehicalAdService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicalAdServiceImp implements VehicalAdService {

    final VehicalAdRepository repository;
    final ModelMapper mapper;

    @Override
    public void saveAd(VehicalAd ad) {
        repository.save(mapper.map(ad, VehicalAdEntity.class));
    }

    @Override
    public void updateAd(Long id, VehicalAd updatedAd) {
        repository.save(mapper.map(updatedAd, VehicalAdEntity.class));
    }

    @Override
    public void deleteAd(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Vehicle ad not found with id: " + id);
        }
    }

    @Override
    public VehicalAd getById(Long id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle ad not found with id: " + id)), VehicalAd.class);
    }

    @Override
    public List<VehicalAd> getAll() {
        List<VehicalAd> list = new ArrayList<>();
        repository.findAll().forEach(entity -> list.add(mapper.map(entity, VehicalAd.class)));
        return list;
    }
}
