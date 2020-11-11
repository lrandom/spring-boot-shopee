package com.example.demo.jpamysql;

import com.example.demo.models.User;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpa extends
        CrudRepository<User, Long>,
        PagingAndSortingRepository<User,Long> {
    Page<User> findAll(Pageable pageable);

    @Query("SELECT COUNT(u) FROM User u")
    public long getTotalUser();
}
