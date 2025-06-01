package io.americanas.legals.repository;

import io.americanas.legals.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInterface extends CrudRepository<User, Integer> {

    User findByEmail(String email);

    User findByName(String name);

    boolean existsByEmail(String email);

    boolean existsByName(String name);
}
