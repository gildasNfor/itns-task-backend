package com.test.intern.canal.service;


import com.test.intern.canal.domain.Canal;

import java.util.List;

public interface CanalPlatformService {

    List<Canal> getAll();

    Canal create(Canal canal);

    Canal updateCanal(String id, Canal canal);

    Canal deleteCanal(String id);
}
