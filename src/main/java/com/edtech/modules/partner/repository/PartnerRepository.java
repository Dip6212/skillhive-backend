package com.edtech.modules.partner.repository;

import com.edtech.modules.partner.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

    List<Partner> findByIsActiveTrueOrderByDisplayOrderAsc();

}