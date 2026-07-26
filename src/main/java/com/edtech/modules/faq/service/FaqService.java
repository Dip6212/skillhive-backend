package com.edtech.modules.faq.service;

import com.edtech.modules.faq.dto.FaqRequest;
import com.edtech.modules.faq.dto.FaqResponse;

import java.util.List;

public interface FaqService {

    List<FaqResponse> getAllFaqs();

    List<FaqResponse> getActiveFaqs();

    FaqResponse createFaq(FaqRequest request);

    FaqResponse updateFaq(Long id,FaqRequest request);

    void deleteFaq(Long id);

}