package io.space4.config.mappers;

import io.space4.config.data.entities.PlainKeyValueStore;
import org.springframework.data.repository.CrudRepository;

public interface PlainKvpRepository extends CrudRepository<PlainKeyValueStore, Long> {
}
