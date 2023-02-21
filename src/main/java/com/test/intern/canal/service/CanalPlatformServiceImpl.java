package com.test.intern.canal.service;

import com.test.intern.canal.domain.Canal;
import com.test.intern.canal.domain.CanalRepository;
import com.test.intern.canal.exceptions.CanalAlreadyExistException;
import com.test.intern.canal.exceptions.CanalNotFounfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CanalPlatformServiceImpl implements CanalPlatformService {

    private final CanalRepository canalRepository;

    @Autowired
    public CanalPlatformServiceImpl(CanalRepository canalRepository) {
        this.canalRepository = canalRepository;
    }

    @Override
    public List<Canal> getAll() {
        return canalRepository.findAll();
    }

    @Override
    public Canal create(Canal canal) {

        Canal foundCanal = canalRepository.findItemByName(canal.getName());

        if(!(foundCanal == null)) throw new CanalAlreadyExistException(canal.getName());

        return canalRepository.save(canal);
    }

    @Override
    public Canal updateCanal(String id, Canal canal) {

        Optional<Canal> found = canalRepository.findById(id);
        if(!(found.isPresent())) throw new CanalNotFounfException(id);
        Canal foundCanal = found.get();
        foundCanal.setName(canal.getName());
        return canalRepository.save(foundCanal);
    }

    @Override
    public Canal deleteCanal(String id) {

        Optional<Canal> found = canalRepository.findById(id);

        if(!found.isPresent()) throw new CanalNotFounfException(id);

        Canal canal = found.get();

        canalRepository.delete(found.get());

        return canal;
    }
}
