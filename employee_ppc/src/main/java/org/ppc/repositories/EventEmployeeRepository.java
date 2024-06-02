package org.ppc.repositories;

import org.ppc.entities.EventEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventEmployeeRepository extends JpaRepository<EventEmployee,Integer> {
    
}
