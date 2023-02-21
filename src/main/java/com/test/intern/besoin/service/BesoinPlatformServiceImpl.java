package com.test.intern.besoin.service;

import com.test.intern.besoin.domain.*;
import com.test.intern.besoin.exceptions.BesoinNotFounfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.test.intern.besoin.service.StatusEnumerations.statusType;

@Service
public class BesoinPlatformServiceImpl implements BesoinPlatformService {

    private final BesoinRepository besoinRepository;

    @Autowired
    public BesoinPlatformServiceImpl(BesoinRepository besoinRepository) {
        this.besoinRepository = besoinRepository;
    }

    @Override
    public List<BesoinResponse> getAll() {
        List<BesoinResponse> besoins = new ArrayList<>();
        try {
            besoinRepository.findAll().forEach(besoin -> {
                BesoinResponse besoinResponse = new BesoinResponse(besoin.getId(),besoin.getDate(), besoin.getDescription(), besoin.getStatus(), besoin.getOffre(), besoin.getDate_envoi(), besoin.getDate_rappel(), besoin.isFile_present());
                besoins.add(besoinResponse);
            });
            return besoins;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return besoins;
    }

    @Override
    public Besoin getOne(String id) {

        Optional<Besoin> besoin = besoinRepository.findById(id);

        if (!besoin.isPresent()) throw new BesoinNotFounfException(id);
        return besoin.get();
    }

    @Override
    public Besoin create(String date, String description, MultipartFile file, String status, String offre, String date_envoi, String date_rappel) {

        Besoin besoin = new Besoin(date, description, status, offre, date_envoi, date_rappel);
        try {

            if (file != null) {
                besoin.setFile(file.getBytes());
                besoin.setContent_type(file.getContentType());
                besoin.setFile_present(true);
            } else {
                besoin.setFile_present(false);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return besoinRepository.save(besoin);
    }

    @Override
    public Besoin updateBesoin(String id, MultipartFile file)  {

        Optional<Besoin> found = besoinRepository.findById(id);
        if (!(found.isPresent())) throw new BesoinNotFounfException(id);
        Besoin foundBesoin = found.get();
        try {
            foundBesoin.setFile(file.getBytes());
            foundBesoin.setFile_present(true);
            foundBesoin.setContent_type(file.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return besoinRepository.save(foundBesoin);
    }

    @Override
    public Besoin deleteBesoin(String id) {

        Optional<Besoin> found = besoinRepository.findById(id);

        if (!found.isPresent()) throw new BesoinNotFounfException(id);

        Besoin besoin = found.get();

        besoinRepository.delete(found.get());

        return besoin;
    }

    @Override
    public List<StatusEnumOptionData> getStatusOptions() {
        return Arrays.asList(statusType(StatusType.TERMINE), statusType(StatusType.EN_COURS));
    }
}
