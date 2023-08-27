package com.prokhnov.interpolCardIndex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CriminalGroupDto {

    private Long id;
    private String groupName;
    private String leaderName;
    private String activities;
    private boolean isMafia;
    private Set<CriminalDto> members;
}
