package icet.edu.service.impl;
import icet.edu.dto.VehicleAd;
import icet.edu.entity.VehicalAdEntity;
import icet.edu.repository.VehicalAdRepository;
import icet.edu.service.VehicalAdService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class VehicalAdServiceImpl implements VehicalAdService {


    private final VehicalAdRepository repository;
    private  final ModelMapper mapper ;

    @Override
    public void saveCarAd(VehicleAd ad) {
          ad.setCreatedAt(String.valueOf(LocalDateTime.now()));
          repository.save(mapper.map(ad, VehicalAdEntity.class));

    }

    @Override
    public VehicleAd getById(Long id) {
        VehicalAdEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle Ad not found with id: " + id));
        return mapper.map(entity, VehicleAd.class);
    }

    @Override
    public List<VehicleAd> getAll() {
        return repository.findAll()
                .stream()
                .map(ad -> mapper.map(ad, VehicleAd.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateAd(Long id, VehicleAd updatedAd) {
        VehicalAdEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle Ad not found with id: " + id));

        // Update fields
        existingEntity.setTitle(updatedAd.getTitle());
        existingEntity.setDescription(updatedAd.getDescription());
        existingEntity.setPrice(updatedAd.getPrice());
        existingEntity.setBrand(updatedAd.getBrand());
        existingEntity.setModel(updatedAd.getModel());
        existingEntity.setImageUrl(updatedAd.getImageUrl());
        existingEntity.setLocation(updatedAd.getLocation());
        existingEntity.setYear(updatedAd.getYear());
        existingEntity.setFualType(updatedAd.getFualType());
        existingEntity.setTransmission(updatedAd.getTransmission());
        existingEntity.setEngineCapacity(updatedAd.getEngineCapacity());
        existingEntity.setCondition(updatedAd.getCondition());
        existingEntity.setMileage(updatedAd.getMileage());
        existingEntity.setContact(updatedAd.getContact());
        existingEntity.setImages(updatedAd.getImages());

        repository.save(existingEntity);
    }

    @Override
    public void deleteAd(Long id) {
       repository.deleteById(id);
    }
}
