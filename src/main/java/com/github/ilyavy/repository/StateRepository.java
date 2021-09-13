package com.github.ilyavy.repository;

import java.util.Optional;

import com.github.ilyavy.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {

    Optional<State> findFirstByContactId(long contactId);
}
