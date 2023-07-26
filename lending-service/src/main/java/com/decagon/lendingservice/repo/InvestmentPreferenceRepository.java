package com.decagon.lendingservice.repo;

import com.decagon.lendingservice.entity.InvestmentPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import java.util.Optional;
import java.util.UUID;

public interface  InvestmentPreferenceRepository extends JpaRepository<InvestmentPreference, UUID> {
    Optional<InvestmentPreference> findByUserId(String userId);



}
