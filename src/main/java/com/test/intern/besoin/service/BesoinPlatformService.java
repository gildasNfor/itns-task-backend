package com.test.intern.besoin.service;


import com.test.intern.besoin.domain.Besoin;
import com.test.intern.besoin.domain.BesoinResponse;
import com.test.intern.besoin.domain.StatusEnumOptionData;
import org.springframework.web.multipart.MultipartFile;
//import java.util.Date;
import java.sql.Date;

import java.util.List;

public interface BesoinPlatformService {

    List<BesoinResponse> getAll();

    Besoin getOne(String id);

    Besoin create(String date, String description, MultipartFile file, String status, String offre, String date_envoi, String date_rappel);

    Besoin updateBesoin(String id, MultipartFile file);

    Besoin deleteBesoin(String id);

    List<StatusEnumOptionData> getStatusOptions();
}
