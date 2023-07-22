package com.communitynotes.domain.mark;

import com.communitynotes.domain.childdisctrict.ChildDistrict;
import com.communitynotes.domain.childdisctrict.DistrictInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

}
