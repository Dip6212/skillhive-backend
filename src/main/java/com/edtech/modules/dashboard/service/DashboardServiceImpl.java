package com.edtech.modules.dashboard.service;

import com.edtech.modules.course.repository.CourseRepository;
import com.edtech.modules.dashboard.dto.DashboardResponse;
import com.edtech.modules.enquiry.dto.EnquiryResponse;
import com.edtech.modules.enquiry.mapper.EnquiryMapper;
import com.edtech.modules.enquiry.repository.EnquiryRepository;
import com.edtech.modules.faq.repository.FaqRepository;
import com.edtech.modules.media.dto.MediaResponse;
import com.edtech.modules.media.mapper.MediaMapper;
import com.edtech.modules.media.repository.MediaRepository;
import com.edtech.modules.partner.repository.PartnerRepository;
import com.edtech.modules.technology.repository.TechnologyRepository;
import com.edtech.modules.testimonial.repository.TestimonialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final CourseRepository courseRepository;
    private final PartnerRepository partnerRepository;
    private final TechnologyRepository technologyRepository;
    private final TestimonialRepository testimonialRepository;
    private final FaqRepository faqRepository;
    private final EnquiryRepository enquiryRepository;
    private final MediaRepository mediaRepository;

    private final EnquiryMapper enquiryMapper;
    private final MediaMapper mediaMapper;

    @Override
    public DashboardResponse getDashboard() {

        List<EnquiryResponse> recentEnquiries = enquiryRepository
                .findTop5ByOrderByCreatedAtDesc()
                .stream()
                .map(enquiryMapper::toResponse)
                .toList();

        List<MediaResponse> recentMedia = mediaRepository
                .findTop5ByOrderByCreatedAtDesc()
                .stream()
                .map(mediaMapper::toResponse)
                .toList();

        return DashboardResponse.builder()
                .totalCourses(courseRepository.count())
                .totalPartners(partnerRepository.count())
                .totalTechnologies(technologyRepository.count())
                .totalTestimonials(testimonialRepository.count())
                .totalFaqs(faqRepository.count())
                .totalEnquiries(enquiryRepository.count())
                .totalMedia(mediaRepository.count())
                .recentEnquiries(recentEnquiries)
                .recentMedia(recentMedia)
                .build();
    }
}