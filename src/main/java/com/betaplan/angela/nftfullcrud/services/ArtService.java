package com.betaplan.angela.nftfullcrud.services;

import com.betaplan.angela.nftfullcrud.models.Art;
import com.betaplan.angela.nftfullcrud.repositories.ArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtService {
    @Autowired
    private ArtRepository artRepository;

    public List<Art> getAllArts(){
        return artRepository.findAll();
    }

    //dependency injectioin
    // Find all arts
    //create new art
    public void createArt(Art art){
        artRepository.save(art); //goes into art repo and sees if the method is there if not it will go to the parent interface CRUD and search there
        //we go into the controller to call this method
    }
    //update new arts
    public void updateArt(Art art){
        artRepository.save(art);
    }

    //delete art
    public void deleteArt(Long id){
        artRepository.deleteById(id);
    }

    //Get Art details
    public Art artDetails(Long id){
        return  artRepository.findById(id).orElse(null);
    }
}
