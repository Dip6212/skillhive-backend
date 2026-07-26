package com.edtech.modules.auth.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.edtech.modules.auth.dto.AdminResponse;
import com.edtech.modules.auth.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    @Mapping(target = "role",source = "role.name")
    AdminResponse toAdminResponse(Admin admin);
}
