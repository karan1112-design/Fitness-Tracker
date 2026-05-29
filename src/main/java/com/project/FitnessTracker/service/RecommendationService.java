package com.project.FitnessTracker.service;

import com.project.FitnessTracker.dto.RecommendationRequest;
import com.project.FitnessTracker.model.Activity;
import com.project.FitnessTracker.model.Recommendation;
import com.project.FitnessTracker.model.User;
import com.project.FitnessTracker.repository.ActivityRepository;
import com.project.FitnessTracker.repository.RecommendationRepository;
import com.project.FitnessTracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;
    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found : " + request.getUserId()));

        Activity activity  = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity Not Found : " + request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        return recommendationRepository.save(recommendation);

    }

    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }
}
