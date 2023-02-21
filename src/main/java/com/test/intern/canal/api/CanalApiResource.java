package com.test.intern.canal.api;

import com.test.intern.canal.domain.Canal;
import com.test.intern.canal.domain.CanalResponse;
import com.test.intern.canal.service.CanalPlatformService;
import com.test.intern.serialization.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/canals")
public class CanalApiResource {

    private final CanalPlatformService canalPlatformService;
    private final JsonSerializer jsonSerializer;


    @Autowired
    public CanalApiResource(CanalPlatformService canalPlatformService, JsonSerializer jsonSerializer) {
        this.canalPlatformService = canalPlatformService;
        this.jsonSerializer = jsonSerializer;
    }

    @GetMapping
    public String getAll() {
        return jsonSerializer.serialize(canalPlatformService.getAll());
    }

    @PostMapping
    public String create(@RequestBody Canal canal) {

        CanalResponse canalResponse;
        try {
            Canal newCanal = canalPlatformService.create(canal);
            canalResponse = new CanalResponse(newCanal);
        } catch (Exception e) {
            canalResponse = new CanalResponse(e.getMessage());

        }
        return jsonSerializer.serialize(canalResponse);
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Canal canal, @PathVariable String id) {

        CanalResponse canalResponse;
        try {
            Canal updatedCanal = canalPlatformService.updateCanal(id,canal);
            canalResponse = new CanalResponse(updatedCanal);
        } catch (Exception e) {
            canalResponse = new CanalResponse(e.getMessage());
        }
        return jsonSerializer.serialize(canalResponse);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {

        CanalResponse canalResponse;
        try {
            Canal updatedCanal = canalPlatformService.deleteCanal(id);
            canalResponse = new CanalResponse(updatedCanal);
        } catch (Exception e) {
            canalResponse = new CanalResponse(e.getMessage());
        }
        return jsonSerializer.serialize(canalResponse);
    }
}
