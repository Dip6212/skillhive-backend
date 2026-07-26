package com.edtech.modules.course.dto;

import com.edtech.modules.course.enums.PackageType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PackageRequest {

    @NotNull
    private PackageType name;

}