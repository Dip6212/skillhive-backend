package com.edtech.modules.dashboard.dto;

import com.edtech.modules.enquiry.dto.EnquiryResponse;
import com.edtech.modules.media.dto.MediaResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private long totalCourses;

    private long totalPartners;

    private long totalTestimonials;

    private long totalTechnologies;

    private long totalFaqs;

    private long totalEnquiries;

    private long totalMedia;

    private List<EnquiryResponse> recentEnquiries;

    private List<MediaResponse> recentMedia;
}