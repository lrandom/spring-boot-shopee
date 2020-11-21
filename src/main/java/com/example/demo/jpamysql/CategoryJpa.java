package com.example.demo.jpamysql;
import com.example.demo.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpa
        extends CrudRepository<Category, Long>,
        PagingAndSortingRepository<Category, Long> {
    Page<Category> findAll(Pageable pageable);

    @Query("SELECT COUNT(u) FROM Category u")
    public Long getTotal();
}
