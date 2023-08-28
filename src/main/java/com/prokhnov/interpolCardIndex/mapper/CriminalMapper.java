package com.prokhnov.interpolCardIndex.mapper;

import com.prokhnov.interpolCardIndex.model.Criminal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.prokhnov.interpolCardIndex.dto.CriminalDto;
/**
 * The {@code CriminalMapper} class.<br/>
 * Class that provide methods to create DTO from Entity and Entity from DTO for Criminal.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Component
public class CriminalMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public CriminalMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CriminalDto toDTO(Criminal criminal) {
        return modelMapper.map(criminal, CriminalDto.class);
    }

    public Criminal toEntity(CriminalDto criminalDTO) {
        return modelMapper.map(criminalDTO, Criminal.class);
    }
}
