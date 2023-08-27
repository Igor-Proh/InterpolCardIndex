package com.prokhnov.interpolCardIndex.service.Impl;

import com.prokhnov.interpolCardIndex.dto.CriminalGroupDto;
import com.prokhnov.interpolCardIndex.mapper.CriminalGroupMapper;
import com.prokhnov.interpolCardIndex.model.CriminalGroup;
import com.prokhnov.interpolCardIndex.repository.CriminalGroupRepository;
import com.prokhnov.interpolCardIndex.service.CriminalGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CriminalGroupServiceImpl implements CriminalGroupService {

    private CriminalGroupRepository criminalGroupRepository;
    private CriminalGroupMapper criminalGroupMapper;

    public CriminalGroupServiceImpl() {
    }

    @Autowired
    public CriminalGroupServiceImpl(CriminalGroupRepository criminalGroupRepository, CriminalGroupMapper criminalGroupMapper) {
        this.criminalGroupRepository = criminalGroupRepository;
        this.criminalGroupMapper = criminalGroupMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CriminalGroupDto> getAllCriminalGroup() {
        List<CriminalGroup> criminals = criminalGroupRepository.findAll();
        return criminals.stream()
                .map(criminalGroupMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void saveCriminalGroup(CriminalGroupDto criminalGroupDto) {

        criminalGroupRepository.save(criminalGroupMapper.toEntity(criminalGroupDto));
    }

    @Override
    @Transactional(readOnly = true)
    public CriminalGroupDto getCriminalGroupById(long id) {
        return criminalGroupMapper.toDTO(criminalGroupRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public void deleteCriminalGroupById(long id) {
        criminalGroupRepository.deleteById(id);
    }
}
