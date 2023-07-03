package com.randevu.service;


import com.randevu.dto.request.RandevuIptalRequestDto;
import com.randevu.dto.request.RandevuSaveRequestDto;
import com.randevu.dto.response.BosRandevuResponseDto;
import com.randevu.dto.response.RandevuListesiResponseDto;
import com.randevu.exceptions.ErrorType;
import com.randevu.exceptions.HastaneRandevuException;
import com.randevu.repository.IRandevuRepository;
import com.randevu.repository.entity.Randevu;
import com.randevu.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RandevuService extends ServiceManager<Randevu,Long> {
    private final IRandevuRepository repository;

    public RandevuService(IRandevuRepository repository) {
        super(repository);
        this.repository=repository;
    }
    public void saveAll(List<Randevu> randevuList) {
        repository.saveAll(randevuList);
    }
    public Optional<Randevu> findByHastaadiAndTarih(String hastaadi, String tarih){
        return repository.findByHastaadiAndTarih(hastaadi,tarih);
    }
    public Optional<Randevu> findByTarihAndHastaadiNotNull(String tarih) {
        return repository.findByTarihAndHastaadiNotNull(tarih);
    }
    public Optional<Randevu> findByTarih(String tarih){
        return repository.findByTarih(tarih);
    }
    public Randevu save(RandevuSaveRequestDto dto) {
        if (findByTarih(dto.getTarih()).isEmpty()){
            throw new HastaneRandevuException(ErrorType.RANDEVUSAATI_BULUNAMADI);
        }else if(findByTarihAndHastaadiNotNull(dto.getTarih()).isPresent()){
            throw new HastaneRandevuException(ErrorType.RANDEVU_DOLU);
        }else{
            Randevu randevu=repository.findByTarih(dto.getTarih()).get();
            randevu.setHastaadi(dto.getHastaadi());
            randevu.setTelefon(dto.getTelefon());
            randevu.setStatus(1);
            return repository.save(randevu);
        }

    }

    public Randevu iptal(RandevuIptalRequestDto dto) {

        if (findByHastaadiAndTarih(dto.getHastaadi(), dto.getTarih()).isEmpty()){
            throw new HastaneRandevuException(ErrorType.RANDEVU_BULUNAMADI);
        }else {
            Randevu randevu=repository.findByHastaadiAndTarih(dto.getHastaadi(), dto.getTarih()).get();
            randevu.setHastaadi(null);
            randevu.setTelefon(null);
            randevu.setStatus(0);
            return repository.save(randevu);
        }


    }

    public List<BosRandevuResponseDto> findAllBosRandevu() {
        return repository.findAllByStatus(0).stream().map(x-> {
            return BosRandevuResponseDto.builder().tarih(x.getTarih()).build();
        }).collect(Collectors.toList());
    }

    public List<RandevuListesiResponseDto> findAllRandevuListesi() {
        return repository.findAllByStatus(1).stream().map(x-> {
            return RandevuListesiResponseDto.builder().hastaadi(x.getHastaadi()).tarih(x.getTarih()).build();
        }).collect(Collectors.toList());
    }

}
