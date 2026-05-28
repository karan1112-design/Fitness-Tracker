package com.project.FitnessTracker.controller;


import com.project.FitnessTracker.dto.ActivityRequest;
import com.project.FitnessTracker.dto.ActivityResponse;
import com.project.FitnessTracker.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;
    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(
            @RequestHeader(value = "x-User-ID")  String userId
    ){
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}

