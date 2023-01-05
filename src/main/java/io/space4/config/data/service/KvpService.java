package io.space4.config.data.service;

import io.space4.config.mappers.PlainKvpRepository;
import io.space4.config.data.entities.PlainKeyValueStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KvpService {

    private final PlainKvpRepository plainKvpRepository;

    public KvpService(PlainKvpRepository plainKvpRepository) {
        this.plainKvpRepository = plainKvpRepository;
    }

    public Iterable<PlainKeyValueStore> list() {
        return plainKvpRepository.findAll();
    }

    public PlainKeyValueStore save(PlainKeyValueStore plainKeyValueStore) {
        return plainKvpRepository.save(plainKeyValueStore);
    }

    public void save(List<PlainKeyValueStore> kvps) {
        plainKvpRepository.saveAll(kvps);
    }
}
