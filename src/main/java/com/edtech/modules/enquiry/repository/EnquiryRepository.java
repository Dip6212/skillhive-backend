package com.edtech.modules.enquiry.repository;

import com.edtech.modules.enquiry.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
    List<Enquiry> findTop5ByOrderByCreatedAtDesc();
}