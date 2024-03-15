package com.serviceMatch.serviceMatch.repository;

import com.serviceMatch.serviceMatch.entities.Skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query("SELECT s FROM Skill s WHERE s.name = :name")
    public Skill findByName(@Param("name") String name);

}
