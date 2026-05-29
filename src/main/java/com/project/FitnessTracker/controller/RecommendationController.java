package com.project.FitnessTracker.controller;


import com.project.FitnessTracker.dto.RecommendationRequest;
import com.project.FitnessTracker.model.Recommendation;
import com.project.FitnessTracker.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
            @RequestBody RecommendationRequest request
    ){
        Recommendation recommendation = recommendationService.generateRecommendation(request);
                return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> generateUserRecommendation(
            @PathVariable String userId
    ){
         List<Recommendation> recommendationList = recommendationService.getUserRecommendation(userId);
        return ResponseEntity.ok(recommendationList);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(
            @PathVariable String activityId
    ){
        List<Recommendation> recommendationList = recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(recommendationList);
    }
}
