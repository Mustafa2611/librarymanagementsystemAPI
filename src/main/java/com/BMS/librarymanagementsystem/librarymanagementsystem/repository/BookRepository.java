package com.BMS.librarymanagementsystem.librarymanagementsystem.repository;

import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
