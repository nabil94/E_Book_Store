package com.example.ecommerce;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.ecommerce.Repository.CategoryRepository;
import com.example.ecommerce.domain.Category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTests {
    
    @Autowired
    private CategoryRepository repo;

    @Test
    public void testCreateCategory(){
        Category savedCategory = repo.save(new Category("Electronics"));
        assertThat(savedCategory.getId()).isGreaterThan(0);
    }
}
