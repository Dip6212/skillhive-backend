package com.edtech.modules.setting.service;

import com.edtech.common.exception.ResourceNotFoundException;
import com.edtech.modules.setting.dto.SettingRequest;
import com.edtech.modules.setting.dto.SettingResponse;
import com.edtech.modules.setting.entity.Setting;
import com.edtech.modules.setting.mapper.SettingMapper;
import com.edtech.modules.setting.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {

    private final SettingRepository settingRepository;
    private final SettingMapper settingMapper;

    @Override
    public List<SettingResponse> getAllSettings() {

        return settingRepository.findAll()
                .stream()
                .map(settingMapper::toResponse)
                .toList();
    }

    @Override
    public SettingResponse getSetting(String key) {

        Setting setting = settingRepository.findByKey(key)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Setting not found with key : " + key
                        ));

        return settingMapper.toResponse(setting);
    }

    @Override
    public SettingResponse saveSetting(SettingRequest request) {

        Setting setting = settingRepository.findByKey(request.getKey())
                .orElse(null);

        if (setting == null) {

            setting = settingMapper.toEntity(request);

        } else {

            setting.setValue(request.getValue());
        }

        Setting savedSetting = settingRepository.save(setting);

        return settingMapper.toResponse(savedSetting);
    }

    @Override
    public void deleteSetting(Long id) {

        Setting setting = settingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Setting not found"
                        ));

        settingRepository.delete(setting);
    }
}