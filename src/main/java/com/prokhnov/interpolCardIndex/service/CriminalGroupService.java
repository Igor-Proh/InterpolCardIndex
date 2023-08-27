package com.prokhnov.interpolCardIndex.service;

import com.prokhnov.interpolCardIndex.dto.CriminalGroupDto;

import java.util.List;

public interface CriminalGroupService {
    List<CriminalGroupDto> getAllCriminalGroup();

    void saveCriminalGroup(CriminalGroupDto criminalGroup);

    CriminalGroupDto getCriminalGroupById(long id);

    void deleteCriminalGroupById(long id);

}
