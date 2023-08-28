package com.prokhnov.interpolCardIndex.controller;

import com.prokhnov.interpolCardIndex.dto.CriminalDto;
import com.prokhnov.interpolCardIndex.service.CriminalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * The {@code CriminalController} class.<br/>
 * Class that provide methods with mapping for Criminal.
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Controller
@RequestMapping("/criminal")
@SessionAttributes({"fromPage"})
public class CriminalController {

    private final CriminalService criminalService;

    @Autowired
    public CriminalController(CriminalService criminalService) {
        this.criminalService = criminalService;
    }

    @GetMapping("/listOfCriminals")
    public String criminalListPage(Model model) {
        List<CriminalDto> allByIsArchivedIsFalse = criminalService.findAllByIsArchivedIsFalse();
        model.addAttribute("criminalList", allByIsArchivedIsFalse);
        model.addAttribute("fromPage", "list");
        return "criminal/criminal_list_page";
    }

    @GetMapping("/listOfArchivedCriminals")
    public String criminalArchivedListPage(Model model) {
        List<CriminalDto> allByIsArchivedIsTrue = criminalService.findAllByIsArchivedIsTrue();
        model.addAttribute("criminalList", allByIsArchivedIsTrue);
        model.addAttribute("fromPage", "archive");
        return "criminal/criminal_archived_list_page";
    }

    @GetMapping("/criminalDetails/{criminalId}")
    public String criminalDetailsPage(@PathVariable Long criminalId, Model model) {
        CriminalDto criminalDto = criminalService.getCriminalById(criminalId);
        model.addAttribute("criminal", criminalDto);
        return "criminal/criminal_details_page";
    }

    @GetMapping("/criminalDelete/{criminalId}")
    public String deleteCriminal(@PathVariable Long criminalId, Model model) {
        criminalService.deleteCriminalById(criminalId);
        List<CriminalDto> allCriminal = criminalService.getAllCriminal();
        model.addAttribute("criminalList", allCriminal);

        if (Objects.equals(model.getAttribute("fromPage"), "archive")) {
            return "redirect:/criminal/listOfArchivedCriminals";
        }
        return "redirect:/criminal/listOfCriminals";
    }

    @GetMapping("/criminalAdd")
    public String showAddCriminalForm(Model model) {
        model.addAttribute("criminal", new CriminalDto());
        return "criminal/criminal_add_update_page";
    }

    @PostMapping("/criminalSave")
    public String saveCriminal(@ModelAttribute CriminalDto criminalDto) {
        criminalService.saveCriminal(criminalDto);
        return "redirect:/criminal/listOfCriminals";
    }

    @GetMapping("/criminalUpdate/{id}")
    public String updateCriminal(@PathVariable Long id, Model model) {
        CriminalDto criminalDto = criminalService.getCriminalById(id);
        model.addAttribute("criminal", criminalDto);

        return "criminal/criminal_add_update_page";
    }

    @PostMapping("/criminalUpdate/{id}")
    public String updateCriminal(@PathVariable Long id, Model model, @ModelAttribute CriminalDto updatedCriminal) {
        CriminalDto existingCriminal = criminalService.getCriminalById(id);

        if (existingCriminal != null) {
            BeanUtils.copyProperties(updatedCriminal, existingCriminal, "id");
            criminalService.saveCriminal(existingCriminal);
        }

        if (Objects.equals(model.getAttribute("fromPage"), "archive")) {
            return "redirect:/criminal/listOfArchivedCriminals";
        }

        return "redirect:/criminal/listOfCriminals";
    }
}
