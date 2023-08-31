package com.prokhnov.interpolCardIndex.controller;


import com.prokhnov.interpolCardIndex.dto.CriminalDto;
import com.prokhnov.interpolCardIndex.dto.CriminalGroupDto;
import com.prokhnov.interpolCardIndex.model.CriminalGroup;
import com.prokhnov.interpolCardIndex.service.CriminalGroupService;
import com.prokhnov.interpolCardIndex.service.CriminalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * The {@code CriminalGroupController} class.<br/>
 * Class that provide methods with mapping for CriminalGroup.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Controller
@RequestMapping("/criminalGroup")
public class CriminalGroupController {

    private final CriminalService criminalService;
    private final CriminalGroupService criminalGroupService;

    @Autowired
    public CriminalGroupController(CriminalService criminalService, CriminalGroupService criminalGroupService) {
        this.criminalService = criminalService;
        this.criminalGroupService = criminalGroupService;
    }

    @GetMapping("/listOfAllCriminalGroups")
    public String criminalListPage(Model model) {
        model.addAttribute("criminalGroupList", criminalGroupService.getAllCriminalGroup());
        return "criminal_group/criminal_group_list_page";
    }
    @GetMapping("/search")
    public String searchCriminalGroups(
            @RequestParam(required = false) String groupName,
            @RequestParam(required = false) String leaderName,
            @RequestParam(required = false) String activities,
            @RequestParam(required = false) Boolean isMafia,
            Model model) {

        List<CriminalGroupDto> searchResults = criminalGroupService.searchCriminalGroups(groupName,leaderName,activities,isMafia);

        model.addAttribute("criminalGroupList", searchResults);
        return "criminal_group/criminal_group_list_page";
    }

    @GetMapping("/criminalGroupDetails/{criminalGroupId}")
    public String criminalGroupDetailsPage(@PathVariable Long criminalGroupId, Model model) {
        CriminalGroupDto criminalGroup = criminalGroupService.getCriminalGroupById(criminalGroupId);
        List<CriminalDto> criminalGroupMembers = criminalService.findCriminalByCriminalGroupId(criminalGroupId);
        model.addAttribute("criminalGroup", criminalGroup);
        model.addAttribute("criminalGroupMembers", criminalGroupMembers);
        return "criminal_group/criminal_group_details_page";
    }

    @GetMapping("/criminalGroupDelete/{id}")
    public String deleteCriminalGroup(@PathVariable Long id, Model model) {
        List<CriminalDto> criminalByCriminalGroupId = criminalService.findCriminalByCriminalGroupId(id);
        for (CriminalDto c : criminalByCriminalGroupId) {
            c.setCriminalGroup(null);
            criminalService.saveCriminal(c);
        }
        criminalGroupService.deleteCriminalGroupById(id);
        List<CriminalGroupDto> allCriminalGroup = criminalGroupService.getAllCriminalGroup();
        model.addAttribute("criminalGroupList", allCriminalGroup);
        return "redirect:/criminalGroup/listOfAllCriminalGroups";
    }

    @GetMapping("/deleteMemberFromGroup/{criminalGroupId}/deleteMember/{memberId}")
    public String deleteMemberFromGroup(@PathVariable Long criminalGroupId, @PathVariable Long memberId) {
        CriminalDto criminalById = criminalService.getCriminalById(memberId);
        criminalById.setCriminalGroup(null);
        criminalService.saveCriminal(criminalById);
        return "redirect:/criminalGroup/criminalGroupDetails/" + criminalGroupId;
    }

    @GetMapping("/criminalGroupAdd")
    public String showAddCriminalGroupForm(Model model) {
        model.addAttribute("criminalGroup", new CriminalGroup());
        return "criminal_group/criminal_group_add_update_page";
    }

    @GetMapping("/criminalGroupAddMembers/{id}")
    public String showAddMembersCriminalGroupForm(@PathVariable Long id, Model model) {
        List<CriminalDto> criminalByCriminalGroupIsNull = criminalService.findCriminalByCriminalGroupIsNull();
        CriminalGroupDto criminalGroupById = criminalGroupService.getCriminalGroupById(id);
        model.addAttribute("criminalList", criminalByCriminalGroupIsNull);
        model.addAttribute("criminalGroup", criminalGroupById);
        return "criminal_group/criminal_group_add_members_page";
    }

    @GetMapping("/criminalGroupSaveMembers/{id}")
    public String saveMembersCriminalGroupForm(@PathVariable Long id, @RequestParam(value = "selectedCriminals"
            , required = false) List<String> selectedCriminals) {
        if (selectedCriminals != null && !selectedCriminals.isEmpty()) {
            selectedCriminals.forEach(criminalId -> {
                CriminalDto criminalById = criminalService.getCriminalById(Long.parseLong(criminalId));
                CriminalGroupDto criminalGroupById = criminalGroupService.getCriminalGroupById(id);

                criminalById.setCriminalGroup(criminalGroupById);
                criminalService.saveCriminal(criminalById);
            });
        }
        return "redirect:/criminalGroup/criminalGroupDetails/" + id;
    }

    @PostMapping("/criminalGroupSave")
    public String saveCriminalGroup(@ModelAttribute CriminalGroupDto criminalGroupDto) {
        criminalGroupService.saveCriminalGroup(criminalGroupDto);
        return "redirect:/criminalGroup/listOfAllCriminalGroups";
    }

    @GetMapping("/criminalGroupUpdate/{id}")
    public String updateCriminalGroup(@PathVariable Long id, Model model) {
        CriminalGroupDto criminalGroup = criminalGroupService.getCriminalGroupById(id);
        model.addAttribute("criminalGroup", criminalGroup);
        return "criminal_group/criminal_group_add_update_page";
    }

    @PostMapping("/criminalGroupUpdate/{id}")
    public String updateCriminalGroup(@PathVariable Long id, @ModelAttribute CriminalGroupDto criminalGroupDto) {
        CriminalGroupDto existingCriminalGroupDto = criminalGroupService.getCriminalGroupById(id);
        if (existingCriminalGroupDto != null) {
            BeanUtils.copyProperties(criminalGroupDto, existingCriminalGroupDto, "id");

            criminalGroupService.saveCriminalGroup(existingCriminalGroupDto);
        }

        return "redirect:/criminalGroup/listOfAllCriminalGroups";
    }
}
