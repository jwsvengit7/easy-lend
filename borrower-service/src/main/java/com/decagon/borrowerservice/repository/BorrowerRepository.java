package com.decagon.borrowerservice.repository;

import com.decagon.borrowerservice.entities.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BorrowerRepository extends JpaRepository<Borrower, UUID> {
}