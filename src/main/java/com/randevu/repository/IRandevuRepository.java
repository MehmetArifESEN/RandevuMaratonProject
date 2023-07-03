package com.randevu.repository;

import com.randevu.repository.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRandevuRepository extends JpaRepository<Randevu,Long> {
    Optional<Randevu> findByHastaadiAndTarih(String hastaadi,String tarih);

    Optional<Randevu> findByTarih(String tarih);

    Optional<Randevu> findByTarihAndHastaadiNotNull(String tarih);

    List<Randevu> findAllByStatus(int status);



}
