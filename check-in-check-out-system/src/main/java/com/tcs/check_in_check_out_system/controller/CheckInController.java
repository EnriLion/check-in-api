package com.tcs.check_in_check_out_system.controller;


import com.tcs.check_in_check_out_system.model.CheckInModel;
//import com.tcs.check_in_check_out_system.model.EmployeeModel;
//import com.tcs.check_in_check_out_system.repository.CheckInRepository;
//import com.tcs.check_in_check_out_system.repository.EmployeeRepository;
import com.tcs.check_in_check_out_system.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;


@Controller
@RequestMapping("/api/v1/check")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;


    @DeleteMapping("/{checkInId}/delete")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long checkInId){
        checkInService.deleteRecord(checkInId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/records")
    public ResponseEntity<List<CheckInModel>> getCheck(){
        try{
            List<CheckInModel> check = checkInService.getCheck();
            return ResponseEntity.ok(check);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{checkInId}/status")
    public ResponseEntity<CheckInModel> updateStatus(@PathVariable Long checkInId) {
        try {
            CheckInModel checkInModel = checkInService.updateStatus(checkInId);
            return ResponseEntity.ok(checkInModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{checkInId}/record")
    public ResponseEntity<List<CheckInModel>> getRecordId(@PathVariable Long checkInId){
        List<CheckInModel> records = checkInService.getRecordId(checkInId);
        return ResponseEntity.ok(records);
    }

}
