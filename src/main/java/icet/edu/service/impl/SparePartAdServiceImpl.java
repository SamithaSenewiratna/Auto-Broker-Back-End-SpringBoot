package icet.edu.service.impl;

import icet.edu.dto.SparePartAd;
import icet.edu.entity.SparePartAdEntity;
import icet.edu.repository.SparePartAdRepository;
import icet.edu.service.SparePartAdService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SparePartAdServiceImpl implements SparePartAdService {

    private final SparePartAdRepository repository;
    private final ModelMapper mapper;

    @Override
    public void saveAd(SparePartAd ad) {
        repository.save(mapper.map(ad, SparePartAdEntity.class));
    }

    @Override
    public void deleteAd(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Spare part ad not found with id: " + id);
        }
    }

    @Override
    public SparePartAd getById(Long id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spare part ad not found with id: " + id)), SparePartAd.class);
    }

    @Override
    public List<SparePartAd> getAll() {
        List<SparePartAd> list = new ArrayList<>();
        repository.findAll().forEach(entity -> list.add(mapper.map(entity, SparePartAd.class)));
        return list;
    }

    @Override
    public void updateAd(Long id, SparePartAd updatedAd) {
        repository.save(mapper.map(updatedAd, SparePartAdEntity.class));
    }
}
