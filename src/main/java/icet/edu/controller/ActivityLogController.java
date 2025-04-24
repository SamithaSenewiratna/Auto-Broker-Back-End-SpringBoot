package icet.edu.controller;

import icet.edu.dto.ActivityLogs;
import icet.edu.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
@RequiredArgsConstructor
public class ActivityLogController {

    final ActivityLogService service;

    @PostMapping
    public void save(@RequestBody ActivityLogs log) {
        service.saveLog(log);
    }

    @GetMapping("/{id}")
    public ActivityLogs getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ActivityLogs> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteLog(id);
    }
}
