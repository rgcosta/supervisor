package com.example.supervisor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCarrierRepository extends JpaRepository<SubCarrier, Long> {
}
