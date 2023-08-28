package com.prokhnov.interpolCardIndex.service.Impl;

import com.prokhnov.interpolCardIndex.dto.CriminalDto;
import com.prokhnov.interpolCardIndex.mapper.CriminalMapper;
import com.prokhnov.interpolCardIndex.model.Criminal;
import com.prokhnov.interpolCardIndex.repository.CriminalRepository;
import com.prokhnov.interpolCardIndex.service.CriminalService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code CriminalServiceImpl} class implements CriminalService.<br/>
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Service
public class CriminalServiceImpl implements CriminalService {

    private CriminalRepository criminalRepository;
    private CriminalMapper criminalMapper;

    public CriminalServiceImpl() {
    }

    @Autowired
    public CriminalServiceImpl(CriminalRepository criminalRepository, CriminalMapper criminalMapper) {
        this.criminalRepository = criminalRepository;
        this.criminalMapper = criminalMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CriminalDto> getAllCriminal() {
        List<Criminal> criminals = criminalRepository.findAll();
        return criminals.stream()
                .map(criminalMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveCriminal(CriminalDto criminalDto) {
        criminalRepository.save(criminalMapper.toEntity(criminalDto));
    }

    @Override
    @Transactional(readOnly = true)
    public CriminalDto getCriminalById(long id) {
        return criminalMapper.toDTO(criminalRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public void deleteCriminalById(long id) {
        criminalRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CriminalDto> findAllByIsArchivedIsTrue() {
        List<Criminal> criminals =criminalRepository.findAllByIsArchivedIsTrue();
        return criminals.stream()
                .map(criminalMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CriminalDto> findAllByIsArchivedIsFalse() {
        List<Criminal> criminals =criminalRepository.findAllByIsArchivedIsFalse();
        return criminals.stream()
                .map(criminalMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CriminalDto> findCriminalByCriminalGroupId(Long id) {
        List<Criminal> criminals =criminalRepository.findCriminalByCriminalGroupId(id);
        return criminals.stream()
                .map(criminalMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CriminalDto> findCriminalByCriminalGroupIsNull() {

        List<Criminal> criminals =criminalRepository.findCriminalByCriminalGroupIsNull();
        return criminals.stream()
                .map(criminalMapper::toDTO)
                .collect(Collectors.toList());
    }
}
