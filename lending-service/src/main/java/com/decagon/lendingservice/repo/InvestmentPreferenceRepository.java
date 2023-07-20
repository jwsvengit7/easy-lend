package com.decagon.lendingservice.repo;

import com.decagon.lendingservice.entity.InvestmentPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  InvestmentPreferenceRepository extends JpaRepository<InvestmentPreference,Long> {
    Optional<InvestmentPreference> findByUserId(String userId);
}
