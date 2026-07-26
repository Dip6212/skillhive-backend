package com.edtech.modules.faq.service;

import com.edtech.common.exception.ResourceNotFoundException;
import com.edtech.modules.faq.dto.FaqRequest;
import com.edtech.modules.faq.dto.FaqResponse;
import com.edtech.modules.faq.entity.Faq;
import com.edtech.modules.faq.mapper.FaqMapper;
import com.edtech.modules.faq.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService {

    private final FaqRepository faqRepository;
    private final FaqMapper faqMapper;

    @Override
    public List<FaqResponse> getAllFaqs() {

        return faqRepository.findAll()
                .stream()
                .map(faqMapper::toResponse)
                .toList();
    }

    @Override
    public List<FaqResponse> getActiveFaqs() {

        return faqRepository.findByIsActiveTrueOrderByDisplayOrderAsc()
                .stream()
                .map(faqMapper::toResponse)
                .toList();
    }

    @Override
    public FaqResponse createFaq(FaqRequest request) {

        Faq faq = faqMapper.toEntity(request);

        Faq savedFaq = faqRepository.save(faq);

        return faqMapper.toResponse(savedFaq);
    }

    @Override
    public FaqResponse updateFaq(
            Long id,
            FaqRequest request
    ) {

        Faq faq = faqRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("FAQ not found"));

        faq.setQuestion(request.getQuestion());
        faq.setAnswer(request.getAnswer());
        faq.setDisplayOrder(request.getDisplayOrder());
        faq.setIsActive(request.getIsActive());

        Faq updatedFaq = faqRepository.save(faq);

        return faqMapper.toResponse(updatedFaq);
    }

    @Override
    public void deleteFaq(Long id) {

        Faq faq = faqRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("FAQ not found"));

        faqRepository.delete(faq);
    }
}