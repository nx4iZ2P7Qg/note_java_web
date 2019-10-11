package org.sodex.web.common.repository;

import org.sodex.web.common.bean.Menstrual;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface MenstrualRepository extends JpaRepository<Menstrual, Long> {

    @NonNull
    Page<Menstrual> findAll(@NonNull Pageable pageable);

}
