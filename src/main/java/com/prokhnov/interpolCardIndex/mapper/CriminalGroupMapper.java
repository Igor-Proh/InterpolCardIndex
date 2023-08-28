package com.prokhnov.interpolCardIndex.mapper;

import com.prokhnov.interpolCardIndex.dto.CriminalGroupDto;
import com.prokhnov.interpolCardIndex.model.CriminalGroup;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The {@code CriminalGroupMapper} class.<br/>
 * Class that provide methods to create DTO from Entity and Entity from DTO for CriminalGroup.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
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
