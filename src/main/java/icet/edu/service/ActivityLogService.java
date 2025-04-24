package icet.edu.service;

import icet.edu.dto.ActivityLogs;

import java.util.List;

public interface ActivityLogService {
    void saveLog(ActivityLogs log);
    ActivityLogs getById(Long id);
    List<ActivityLogs> getAll();
    void deleteLog(Long id);
}
