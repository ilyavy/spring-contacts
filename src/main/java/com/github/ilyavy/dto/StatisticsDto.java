package com.github.ilyavy.dto;

import java.util.Map;

import com.github.ilyavy.model.StateType;

public class StatisticsDto {

    Map<StateType, Long> states;

    public Map<StateType, Long> getStates() {
        return states;
    }

    public StatisticsDto setStates(Map<StateType, Long> states) {
        this.states = states;
        return this;
    }
}
