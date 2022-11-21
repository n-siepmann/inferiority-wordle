/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nicksiepmann.inferioritywordle;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;


/**
 *
 * @author Nick.Siepmann
 */

@Repository
public interface ScoreRepository extends DatastoreRepository<Score, Long> {    
    /**
     *
     * @param name
     * @return
     */
    List<Score> findByWord(String word);
    List<Score> findAll();
}
