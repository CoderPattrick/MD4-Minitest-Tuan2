package com.repo;

import com.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends PagingAndSortingRepository<Book,Long> {
}
