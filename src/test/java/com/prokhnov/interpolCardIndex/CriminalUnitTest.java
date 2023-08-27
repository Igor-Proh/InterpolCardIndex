package com.prokhnov.interpolCardIndex;

import com.prokhnov.interpolCardIndex.configuration.UnitTestConfiguration;
import com.prokhnov.interpolCardIndex.dto.CriminalDto;
import com.prokhnov.interpolCardIndex.service.CriminalService;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class CriminalUnitTest extends UnitTestConfiguration {

    @Autowired
    private CriminalService criminalService;

    @Test
    @DataSet("criminal_data/empty_criminal.yml")
    @ExpectedDataSet("criminal_data/add_criminal.yml")
    public void testShouldAddCriminal() throws Exception {

        CriminalDto newCriminal = CriminalDto.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .nickname("Snake")
                .height(180.5)
                .hairColor("Black")
                .eyeColor("Blue")
                .distinguishingFeatures("Tattoo on left arm")
                .nationality("American")
                .birthDate(null)
                .lastKnownAddress("123 Main St, City")
                .languages("English, Spanish")
                .criminalProfession("Burglar")
                .lastCrimeDetails("Robbery at ABC Bank")
                .isArchived(false)
                .isDead(false)
                .build();

        criminalService.saveCriminal(newCriminal);

        assertEquals(1, criminalService.getAllCriminal().size());

    }

    @Test
    @DataSet("criminal_data/add_criminal.yml")
    @ExpectedDataSet("criminal_data/empty_criminal.yml")
    public void testShouldDeleteCriminalById() throws Exception {
        criminalService.deleteCriminalById(1L);

        assertEquals(0, criminalService.getAllCriminal().size());
    }

    @Test
    @DataSet("criminal_data/add_criminal.yml")
    @ExpectedDataSet("criminal_data/update_criminal.yml")
    public void testShouldUpdateCriminalById() throws Exception {
        CriminalDto criminalDto = criminalService.getCriminalById(1L);
        String s = criminalDto.getNickname() + "Test";
        criminalDto.setNickname(s);
        criminalService.saveCriminal(criminalDto);

        assertEquals(s, criminalService.getCriminalById(1L).getNickname());
    }

}
