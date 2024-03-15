package com.serviceMatch.serviceMatch.repository;

import com.serviceMatch.serviceMatch.entities.Job;
import com.serviceMatch.serviceMatch.entities.Provider;
import com.serviceMatch.serviceMatch.enums.RolEnum;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    Provider findByName(String name);

    public List<Provider> findByRol(RolEnum rol);

    @Query("SELECT DISTINCT j FROM Job j INNER JOIN j.provider p WHERE p.rol = 'PROVEEDOR' AND p.id = :userId")
    List<Job> findByProvider(@Param("userId") Long userId);
}
