package com.vbs.service;

import com.vbs.model.Court;
import com.vbs.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourtService {

    @Autowired
    private CourtRepository courtRepository;

    public Optional<Court> getUserById(Long id){
        return courtRepository.findById(id);
    }

    public boolean saveCourt(Court court){
        courtRepository.save(court);
        return  true;
    }

    public boolean deleteCourtById(Long id){
        Court court = courtRepository.getById(id);
        if(court == null){
            return false;
        }
        courtRepository.delete(court);
        return true;
    }

    public boolean updateCourt(Court court){
        if(courtRepository.findById(court.getId()) == null){
            return false;
        }
        courtRepository.save(court);
        return  true;
    }

    public List<Court> listCourt(){
        return courtRepository.findAll();
    }
}
