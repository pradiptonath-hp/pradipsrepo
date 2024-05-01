package com.his.ar.service;

import com.his.ar.entity.CitizenApp;
import com.his.ar.repo.CitizenAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class CitizenAppServiceImpl implements CitizenAppService {

    @Autowired
    private CitizenAppRepository appRepo;

    @Value("${ssaUrl}")
    private String ssaUrl;


    @Override
    public boolean createApplication(CitizenApp app) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity(ssaUrl, String.class, app.getSsn());
        String body = response.getBody();
        if (body.equalsIgnoreCase("Rhode Island")){
            appRepo.save(app);
            return true;
        }
        return false;
    }


    @Override
    public CitizenApp getApp(Integer appNum) {
        return appRepo.findById(appNum).orElseThrow();
    }

    @Override
    public List<CitizenApp> getApps() {
        return appRepo.findAll();

    }

    @Override
    public CitizenApp getbyCitizenId(Integer citizenId) {
        return appRepo.findById(citizenId).orElseThrow();
    }

}
