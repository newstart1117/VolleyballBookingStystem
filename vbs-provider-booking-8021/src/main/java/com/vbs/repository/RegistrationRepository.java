package com.vbs.repository;

import com.vbs.model.ActivityRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<ActivityRegistration, Long> {
}
