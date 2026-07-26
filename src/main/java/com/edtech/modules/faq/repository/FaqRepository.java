package com.edtech.modules.faq.repository;

import com.edtech.modules.faq.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaqRepository extends JpaRepository<Faq,Long> {

    List<Faq> findByIsActiveTrueOrderByDisplayOrderAsc();

}