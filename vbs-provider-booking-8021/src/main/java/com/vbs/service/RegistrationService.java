package com.vbs.service;

import com.vbs.model.ActivityRegistration;
import com.vbs.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Optional<ActivityRegistration> getRegistrationById(long id){
        return registrationRepository.findById(id);
    }

    public boolean saveRegistration(ActivityRegistration registration){
        registrationRepository.save(registration);
        return  true;
    }

    public boolean deleteRegistrationById(Long id){
        ActivityRegistration registration = registrationRepository.getById(id);
        if(registration == null){
            return false;
        }
        registrationRepository.delete(registration);
        return true;
    }

    public boolean updateRegistration(ActivityRegistration registration){
        if(registrationRepository.findById(registration.getId()) == null){
            return false;
        }
        registrationRepository.save(registration);
        return  true;
    }

    public List<ActivityRegistration> listRegistration(){
        return registrationRepository.findAll();
    }

}
