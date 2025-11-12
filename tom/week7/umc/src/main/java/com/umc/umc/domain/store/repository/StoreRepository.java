package com.umc.umc.domain.store.repository;

import com.umc.umc.domain.store.entity.Region;
import com.umc.umc.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
    Store region(Region region);
}
