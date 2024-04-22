package com.BMS.librarymanagementsystem.librarymanagementsystem.repository;

import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
}
