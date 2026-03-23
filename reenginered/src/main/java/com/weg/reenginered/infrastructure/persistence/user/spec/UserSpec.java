package com.weg.reenginered.infrastructure.persistence.user.spec;

import com.weg.reenginered.domain.dto.filter.UserFilter;
import com.weg.reenginered.domain.entity.User;
import com.weg.reenginered.infrastructure.persistence.user.UserJpa;
import org.springframework.data.jpa.domain.Specification;

public class    UserSpec {

    public static Specification<UserJpa> filter(UserFilter userFilter){
        return Specification
                .where(filterName(userFilter.getName()))
                .or(filterEmail(userFilter.getEmail()));
    }

    public static Specification<UserJpa> filterEmail(String email){
        return (root, query, criteriaBuilder) -> {
            if (email == null || email.isBlank()) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%"+email.toLowerCase()+"%");
        };
    }

    public static Specification<UserJpa> filterName(String name){
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isBlank()) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%"+name.toLowerCase()+"%");
        };
    }
}
