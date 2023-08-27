package com.prokhnov.interpolCardIndex.mapper;

import com.prokhnov.interpolCardIndex.dto.CriminalGroupDto;
import com.prokhnov.interpolCardIndex.model.CriminalGroup;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriminalGroupMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public CriminalGroupMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CriminalGroupDto toDTO(CriminalGroup criminalGroup) {
        return modelMapper.map(criminalGroup, CriminalGroupDto.class);
    }

    public CriminalGroup toEntity(CriminalGroupDto criminalGroupDTO) {
        return modelMapper.map(criminalGroupDTO, CriminalGroup.class);
    }
}
