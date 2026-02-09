package com.example.crm.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

    List<ContractEntity> findByClientId(Long clientId);
}
