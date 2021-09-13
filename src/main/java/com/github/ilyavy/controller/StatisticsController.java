package com.github.ilyavy.controller;

import java.util.HashMap;
import java.util.Map;

import com.github.ilyavy.dto.StatisticsDto;
import com.github.ilyavy.model.StateType;
import com.github.ilyavy.service.StateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class StatisticsController {

    private final StateService stateService;

    public StatisticsController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/statistics/states")
    public StatisticsDto get() {
        Map<StateType, Long> stateCounts = new HashMap<>();

        for (StateType stateType : StateType.values()) {
            stateCounts.put(stateType, stateService.countByState(stateType));
        }

        return new StatisticsDto().setStates(stateCounts);
    }
}
