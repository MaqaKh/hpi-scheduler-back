package com.communitynotes.domain.childdisctrict;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChildDistrictRepository extends JpaRepository<ChildDistrict, Integer> {

    @Query("SELECT new com.communitynotes.domain.childdisctrict.DistrictInfo(c.id, c.name, m.name, m.id) FROM ChildDistrict c JOIN c.mainDistrict m")
    List<DistrictInfo> findAllDistrictsWithParentName();
}
