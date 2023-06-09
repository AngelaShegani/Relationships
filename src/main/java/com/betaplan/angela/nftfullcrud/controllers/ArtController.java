package com.betaplan.angela.nftfullcrud.controllers;

import com.betaplan.angela.nftfullcrud.models.Art;
import com.betaplan.angela.nftfullcrud.services.ArtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ArtController {
    @Autowired
    private ArtService artService;

    @GetMapping("/")
    public String index(Model artModel){
        List<Art> arts= artService.getAllArts();
        artModel.addAttribute("allArts", arts);
        return "index";
    }

    @GetMapping("/new")
    public String newArt(@ModelAttribute("newArt") Art newArt) {
        return "newP";
    }

    //Create ART

    @PostMapping("/create")
    public String createArt(@Valid @ModelAttribute("newArt") Art newArt, BindingResult result){
        if(result.hasErrors()){
            return "newP";
        }else{
            //go to services to create a new art
            artService.createArt(newArt);
            return "redirect:/";
        }
    }
    //Update Method
    @GetMapping("/edit/{id}")
    public String editArt(@PathVariable Long id, Model model) {
        //i need to edit the info but i also need to show the info from the current state
        //go to services to get all the data
        //create an object that passes the data to that specific id
        Art editArt=artService.artDetails(id);
        model.addAttribute("editArt",editArt);
        return "edit";

    }
    @PutMapping("/update/{id}")
    public String updateArt(@Valid @ModelAttribute("editArt") Art editArt, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return "edit";
        }else{
            artService.updateArt(editArt);
            return "redirect:/";
        }

    }

    //Delete Art
    //@GetMapping("/delete/{id}")
    //public String deletaArt(@PathVariable Long id){
    //artService.deleteArt(id);
    // return "rdirect:/";
    //try on the url to put the id,you can delete the item from the url bad practice

    //}
    @DeleteMapping("/delete/{id}")
    public String deleteArt(@PathVariable Long id){
        artService.deleteArt(id);
        return "redirect:/";


    }
    //Art Details
    @GetMapping("/artDetails/{id}")
    public String artDetails(@PathVariable Long id, Model model) {
        Art art = artService.artDetails(id);
        model.addAttribute("art", art);
        return "details";

    }

}
