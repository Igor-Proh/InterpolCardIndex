package com.prokhnov.interpolCardIndex.service;

import com.prokhnov.interpolCardIndex.dto.CriminalDto;

import java.util.List;

public interface CriminalService {
    List<CriminalDto> getAllCriminal();

    void saveCriminal(CriminalDto criminal);

    CriminalDto getCriminalById(long id);

    void deleteCriminalById(long id);

    List<CriminalDto> findAllByIsArchivedIsTrue();

    List<CriminalDto> findAllByIsArchivedIsFalse();

    List<CriminalDto> findCriminalByCriminalGroupId(Long id);

    List<CriminalDto> findCriminalByCriminalGroupIsNull();
}
