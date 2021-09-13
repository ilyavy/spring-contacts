package com.github.ilyavy.dto;

import com.github.ilyavy.model.StateType;

public class StateDto {

    private Long id;

    private StateType state;

    public Long getId() {
        return id;
    }

    public StateDto setId(Long id) {
        this.id = id;
        return this;
    }

    public StateType getState() {
        return state;
    }

    public StateDto setState(StateType state) {
        this.state = state;
        return this;
    }
}
