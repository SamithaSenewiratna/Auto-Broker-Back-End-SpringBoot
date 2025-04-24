package icet.edu.service.impl;

import icet.edu.dto.ActivityLogs;
import icet.edu.entity.ActivityLogEntity;
import icet.edu.repository.ActivityLogRepository;
import icet.edu.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    final ActivityLogRepository repository;
    final ModelMapper mapper;

    @Override
    public void saveLog(ActivityLogs log) {
        repository.save(mapper.map(log, ActivityLogEntity.class));
    }

    @Override
    public ActivityLogs getById(Long id) {
        ActivityLogEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found with id: " + id));
        return mapper.map(entity, ActivityLogs.class);
    }

    @Override
    public List<ActivityLogs> getAll() {
        List<ActivityLogEntity> all = repository.findAll();
        List<ActivityLogs> list = new ArrayList<>();

        all.forEach(entity -> list.add(mapper.map(entity, ActivityLogs.class)));

        return list;
    }

    @Override
    public void deleteLog(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Log with ID " + id + " not found");
        }
    }
}
