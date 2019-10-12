package org.sodex.web.common.repository;

import org.sodex.web.common.bean.Menstrual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenstrualRepository extends JpaRepository<Menstrual, Long> {

}
