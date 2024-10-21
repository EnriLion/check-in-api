package com.tcs.check_in_check_out_system.service;

import com.tcs.check_in_check_out_system.model.CheckInModel;
//import com.tcs.check_in_check_out_system.model.EmployeeModel;
import com.tcs.check_in_check_out_system.repository.CheckInRepository;
//import com.tcs.check_in_check_out_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CheckInService {

    @Autowired
    private CheckInRepository checkInRepository;


    public void deleteRecord(Long checkInId){
        checkInRepository.deleteById(checkInId);
    }

    public List<CheckInModel> getCheck(){
       List<CheckInModel>  check = new ArrayList<>();
       for(CheckInModel checkInModel : checkInRepository.findAll())
           check.add(checkInModel);
       return check;
    }

    public CheckInModel updateStatus(Long checkInId){
       CheckInModel checkInModel = checkInRepository.findById(checkInId).orElseThrow(NoSuchElementException:: new);
       checkInModel.setCheckOutTime(LocalDateTime.now());
       checkInModel.setStatus(true);
       return  checkInRepository.save(checkInModel);
    }

    public List<CheckInModel> getRecordId(Long checkInId){
        CheckInModel checkInModel = checkInRepository.findById(checkInId).orElseThrow(NoSuchElementException::new);
        List<CheckInModel> records = new LinkedList<>();
        records.add(checkInModel);
        return records;
    }


}
