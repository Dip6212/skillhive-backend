package com.edtech.modules.setting.service;

import com.edtech.modules.setting.dto.SettingRequest;
import com.edtech.modules.setting.dto.SettingResponse;

import java.util.List;

public interface SettingService {

    List<SettingResponse> getAllSettings();

    SettingResponse getSetting(String key);

    SettingResponse saveSetting(SettingRequest request);

    void deleteSetting(Long id);

}