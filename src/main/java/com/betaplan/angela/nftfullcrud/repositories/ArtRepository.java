package com.betaplan.angela.nftfullcrud.repositories;

import com.betaplan.angela.nftfullcrud.models.Art;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtRepository extends CrudRepository<Art,Long> {
    List<Art> findAll();
}
