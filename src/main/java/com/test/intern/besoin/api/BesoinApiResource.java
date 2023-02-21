package com.test.intern.besoin.api;

import com.test.intern.besoin.domain.Besoin;
import com.test.intern.besoin.domain.BesoinResponse;
import com.test.intern.besoin.domain.StatusEnumOptionData;
import com.test.intern.besoin.service.BesoinPlatformService;
import com.test.intern.serialization.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.datastax.oss.driver.shaded.guava.common.net.HttpHeaders.*;

import java.util.Base64;
//import java.util.Date;
import java.sql.Date;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/besoins")
public class BesoinApiResource {

    private final BesoinPlatformService besoinPlatformService;
    private final JsonSerializer jsonSerializer;


    @Autowired
    public BesoinApiResource(BesoinPlatformService besoinPlatformService, JsonSerializer jsonSerializer) {
        this.besoinPlatformService = besoinPlatformService;
        this.jsonSerializer = jsonSerializer;
    }

    @GetMapping
    public String getAll() {
        return jsonSerializer.serialize(besoinPlatformService.getAll());
    }

    @PostMapping
    public String create(@RequestParam(required = false) String date,
                         @RequestParam(required = false) String description,
                         @RequestParam(required = false) MultipartFile file,
                         @RequestParam(required = false) String status,
                         @RequestParam(required = false) String offre,
                         @RequestParam(required = false) String date_envoi,
                         @RequestParam(required = false) String date_rappel) {

        BesoinResponse besoinResponse;
        try {

            Besoin newBesoin = besoinPlatformService.create(date, description, file, status, offre, date_envoi, date_rappel);
            besoinResponse = new BesoinResponse(newBesoin.getId(), newBesoin.getDate(), newBesoin.getDescription(), newBesoin.getStatus(), newBesoin.getOffre(), newBesoin.getDate_envoi(), newBesoin.getDate_rappel(), newBesoin.isFile_present());
        } catch (Exception e) {
            besoinResponse = new BesoinResponse(e.getMessage());

        }
        return jsonSerializer.serialize(besoinResponse);
    }

    @PutMapping("/{id}")
    public String update(@RequestParam MultipartFile file, @PathVariable String id) {

        BesoinResponse besoinResponse;
        try {
            Besoin updatedBesoin = besoinPlatformService.updateBesoin(id, file);
            besoinResponse = new BesoinResponse(updatedBesoin.getId(), updatedBesoin.getDate(), updatedBesoin.getDescription(), updatedBesoin.getStatus(), updatedBesoin.getOffre(), updatedBesoin.getDate_envoi(), updatedBesoin.getDate_rappel(), updatedBesoin.isFile_present());
        } catch (Exception e) {
            besoinResponse = new BesoinResponse(e.getMessage());
        }
        return jsonSerializer.serialize(besoinResponse);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {

        BesoinResponse besoinResponse;
        try {
            Besoin deletedBesoin = besoinPlatformService.deleteBesoin(id);
            besoinResponse = new BesoinResponse(deletedBesoin.getId(), deletedBesoin.getDate(), deletedBesoin.getDescription(), deletedBesoin.getStatus(), deletedBesoin.getOffre(), deletedBesoin.getDate_envoi(), deletedBesoin.getDate_rappel(), deletedBesoin.isFile_present());
        } catch (Exception e) {
            besoinResponse = new BesoinResponse(e.getMessage());
        }
        return jsonSerializer.serialize(besoinResponse);
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<Resource> getFile(@PathVariable String id) {
        Besoin besoin = besoinPlatformService.getOne(id);
        int fileSize = besoin.getFile().length;
        String contentType = besoin.getContent_type();

        return ResponseEntity.ok()
                .header(CONTENT_TYPE, contentType)
                .header(CONTENT_LENGTH, String.valueOf(fileSize))
                .body(new ByteArrayResource(besoin.getFile()));
    }

    @GetMapping("/status/types")
    public List<StatusEnumOptionData> getTypes() {

        List<StatusEnumOptionData> statusEnumOptionData = besoinPlatformService.getStatusOptions();
        return statusEnumOptionData;
    }

    @GetMapping("/test")
    public String print() {
        return "Testing deployment";
    }
}
