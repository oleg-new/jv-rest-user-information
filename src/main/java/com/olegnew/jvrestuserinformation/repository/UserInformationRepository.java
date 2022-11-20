package com.olegnew.jvrestuserinformation.repository;

import com.olegnew.jvrestuserinformation.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {
}
