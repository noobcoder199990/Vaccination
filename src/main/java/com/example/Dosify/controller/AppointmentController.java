package com.example.Dosify.controller;

import com.example.Dosify.dto.RequestDTO.AppointmentRequestDto;
import com.example.Dosify.dto.ResponseDTO.AppointmentResponseDto;
import com.example.Dosify.exception.DoctorNotFoundException;
import com.example.Dosify.exception.NotEligibleForDoseException;
import com.example.Dosify.exception.UserNotFoundException;
import com.example.Dosify.service.AppointmentService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownServiceException;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) throws Exception {
          try{
              AppointmentResponseDto res=appointmentService.bookAppointment(appointmentRequestDto);
              return new ResponseEntity(res,HttpStatus.OK);
          }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
    }

    // generate certificate
       // -> One dose
       // -> Both dose
}
