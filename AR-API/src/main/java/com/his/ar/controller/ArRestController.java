package com.his.ar.controller;


import com.his.ar.entity.CitizenApp;
import com.his.ar.service.CitizenAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArRestController
{

    @Autowired
    private CitizenAppService citizenService;

    @PostMapping("/app")
    public ResponseEntity<String> createApp(@RequestBody CitizenApp citizenApp){
        boolean status = citizenService.createApplication(citizenApp);
        if (status){
                return new ResponseEntity<String>("SUCCESS:App Created", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<String>("Error:INVALID SSN", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/apps")
    public ResponseEntity<List<CitizenApp>> getAllApps(){
        List<CitizenApp> apps = citizenService.getApps();
        return new ResponseEntity<>(apps,HttpStatus.OK);
    }

    @GetMapping("/app/{appNum}")
    public ResponseEntity<CitizenApp> getApp(@PathVariable("appNum") Integer appNum) {
        CitizenApp app = citizenService.getApp(appNum);
        return  new ResponseEntity<CitizenApp>(app,HttpStatus.OK);
    }

    @GetMapping("/citizen_id/{citizenId}")
    public ResponseEntity<CitizenApp> getAppByCitizenId(@PathVariable("citizenId") Integer citizenId) {
        CitizenApp app = citizenService.getbyCitizenId(citizenId);
        return  new ResponseEntity<CitizenApp>(app,HttpStatus.OK);
    }

}
