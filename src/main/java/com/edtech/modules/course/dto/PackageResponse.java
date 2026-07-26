package com.edtech.modules.course.dto;

import com.edtech.modules.course.enums.PackageType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PackageResponse {

    private Long id;

    private PackageType name;

    private List<ModuleResponse> modules;

}