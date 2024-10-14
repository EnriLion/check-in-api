package com.tcs.check_in_check_out_system.service;

import com.tcs.check_in_check_out_system.model.CheckInModel;
//import com.tcs.check_in_check_out_system.model.EmployeeModel;
import com.tcs.check_in_check_out_system.repository.CheckInRepository;
//import com.tcs.check_in_check_out_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CheckInService {

    @Autowired
    private CheckInRepository checkInRepository;


    public CheckInModel createdCheckIn(){
        CheckInModel checkInModel = new CheckInModel();
        checkInModel.setCheckInTime(LocalDateTime.now());
        checkInModel.setCheckOutTime(LocalDateTime.now());
        checkInModel.setStatus(false);
        checkInModel.setPerson(0L);
        checkInRepository.save(checkInModel);
        return checkInModel;
    }

    public void deleteRecord(Long checkInId){
        checkInRepository.deleteById(checkInId);
    }

    public List<CheckInModel> getCheck(){
       List<CheckInModel>  check = new ArrayList<>();
       for(CheckInModel checkInModel : checkInRepository.findAll())
           check.add(checkInModel);
       return check;
    }

    public CheckInModel updateStatus(Long checkInId, boolean status){
       CheckInModel checkInModel = checkInRepository.findById(checkInId).orElseThrow(NoSuchElementException:: new);
       checkInModel.setStatus(status);
       return  checkInRepository.save(checkInModel);
    }

}
