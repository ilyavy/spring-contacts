package com.github.ilyavy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class State {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Contact contact;

    private StateType state;

    public StateType getState() {
        return state;
    }

    public State setState(StateType state) {
        this.state = state;
        return this;
    }
}
