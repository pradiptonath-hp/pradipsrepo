package com.his.ar.service;

import com.his.ar.entity.CitizenApp;

import java.util.List;

public interface CitizenAppService {

    public boolean  createApplication(CitizenApp app);

    public CitizenApp getApp(Integer appNum);

    public List<CitizenApp> getApps();

    public CitizenApp getbyCitizenId(Integer citizenI);
}
