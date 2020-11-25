package com.example.demo.jpamysql;
import com.example.demo.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryJpa
        extends CrudRepository<Category, Long>,
        PagingAndSortingRepository<Category, Long> {
    Page<Category> findAll(Pageable pageable);

    @Query("SELECT COUNT(u) FROM Category u")
    public Long getTotal();

    @Query("SELECT u from Category u")
    List<Category> findAll();

    @Query("SELECT u from Category u WHERE id != ?1")
    List<Category> findAll(Long id);
}
