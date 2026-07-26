package com.edtech.modules.setting.mapper;

import com.edtech.modules.setting.dto.SettingRequest;
import com.edtech.modules.setting.dto.SettingResponse;
import com.edtech.modules.setting.entity.Setting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SettingMapper {

    Setting toEntity(SettingRequest request);

    SettingResponse toResponse(Setting setting);

}