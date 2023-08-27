package com.prokhnov.interpolCardIndex;

import com.prokhnov.interpolCardIndex.configuration.UnitTestConfiguration;
import com.prokhnov.interpolCardIndex.dto.CriminalDto;
import com.prokhnov.interpolCardIndex.dto.CriminalGroupDto;
import com.prokhnov.interpolCardIndex.service.CriminalGroupService;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CriminalGroupUnitTest extends UnitTestConfiguration {

    @Autowired
    private CriminalGroupService criminalGroupService;

    @Test
    @DataSet("criminal_group_data/empty_criminal_group.yml")
    @ExpectedDataSet("criminal_group_data/add_criminal_group.yml")
    public void testShouldAddCriminalGroup() throws Exception {

        Set<CriminalDto> members = new HashSet<>();

        CriminalGroupDto newCriminalGroup = CriminalGroupDto.builder()
                .id(1L)
                .groupName("Group A")
                .leaderName("Leader X")
                .activities("Illegal activities")
                .isMafia(true)
                .members(members)
                .build();

        criminalGroupService.saveCriminalGroup(newCriminalGroup);
        CriminalGroupDto criminalGroupById = criminalGroupService.getCriminalGroupById(1L);

        assertEquals(newCriminalGroup, criminalGroupById);

    }

    @Test
    @DataSet("criminal_group_data/add_criminal_group.yml")
    @ExpectedDataSet("criminal_group_data/empty_criminal_group.yml")
    public void testShouldDeleteCriminalGroupById() throws Exception {
        criminalGroupService.deleteCriminalGroupById(1L);

        assertEquals(0, criminalGroupService.getAllCriminalGroup().size());
    }

    @Test
    @DataSet("criminal_group_data/add_criminal_group.yml")
    @ExpectedDataSet("criminal_group_data/update_criminal_group.yml")
    public void testShouldUpdateCriminalGroupById() throws Exception {
        CriminalGroupDto criminalGroupDto = criminalGroupService.getCriminalGroupById(1L);
        String s = criminalGroupDto.getGroupName() + "Test";
        criminalGroupDto.setGroupName(s);
        criminalGroupService.saveCriminalGroup(criminalGroupDto);

        assertEquals(s, criminalGroupService.getCriminalGroupById(1L).getGroupName());
    }
}
