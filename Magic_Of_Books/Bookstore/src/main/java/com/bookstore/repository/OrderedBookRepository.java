package com.bookstore.repository;

import com.bookstore.model.entity.OrderedBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedBookRepository extends JpaRepository<OrderedBookEntity, Long> {
}
