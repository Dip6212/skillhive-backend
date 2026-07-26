package com.edtech.modules.hero.mapper;

import com.edtech.modules.hero.dto.HeroRequest;
import com.edtech.modules.hero.dto.HeroResponse;
import com.edtech.modules.hero.entity.Hero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HeroMapper {

    @Mapping(target = "heroImage", ignore = true)
    @Mapping(target = "backgroundImage", ignore = true)
    Hero toEntity(HeroRequest request);

    @Mapping(target = "heroImage", ignore = true)
    @Mapping(target = "backgroundImage", ignore = true)
    HeroResponse toResponse(Hero hero);
}