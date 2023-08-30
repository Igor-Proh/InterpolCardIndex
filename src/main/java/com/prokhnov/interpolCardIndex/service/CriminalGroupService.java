package com.prokhnov.interpolCardIndex.service;

import com.prokhnov.interpolCardIndex.dto.CriminalGroupDto;
import com.prokhnov.interpolCardIndex.model.CriminalGroup;

import java.util.List;
/**
 * The {@code CriminalGroupService} interface.<br/>
 * Service layer of CriminalGroup.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
public interface CriminalGroupService {
    List<CriminalGroupDto> getAllCriminalGroup();

    void saveCriminalGroup(CriminalGroupDto criminalGroup);

    CriminalGroupDto getCriminalGroupById(long id);

    void deleteCriminalGroupById(long id);

    List<CriminalGroupDto> searchCriminalGroups(String groupName,
                                                String leaderName,
                                                String activities,
                                                Boolean isMafia);

}
