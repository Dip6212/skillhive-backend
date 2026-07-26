package com.edtech.modules.testimonial.repository;

import com.edtech.modules.testimonial.entity.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestimonialRepository
        extends JpaRepository<Testimonial, Long> {

    List<Testimonial> findByIsActiveTrueOrderByDisplayOrderAsc();

}
