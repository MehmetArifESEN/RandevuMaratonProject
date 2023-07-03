package com.randevu.utility;

import com.randevu.repository.entity.Randevu;
import com.randevu.service.RandevuService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataImpl implements ApplicationRunner {
    private final RandevuService randevuService;

    @Override
    public void run(ApplicationArguments args) throws Exception{
       // createRandevuTime();

    }
    public void createRandevuTime() {
        Randevu randevu= Randevu.builder().tarih("09.00").status(0).build();
        Randevu randevu1= Randevu.builder().tarih("09.30").status(0).build();
        Randevu randevu2= Randevu.builder().tarih("10.00").status(0).build();
        Randevu randevu3= Randevu.builder().tarih("10.30").status(0).build();
        Randevu randevu4= Randevu.builder().tarih("11.00").status(0).build();
        Randevu randevu5= Randevu.builder().tarih("11.30").status(0).build();
        Randevu randevu6= Randevu.builder().tarih("12.00").status(0).build();
        Randevu randevu7= Randevu.builder().tarih("12.30").status(0).build();
        Randevu randevu8= Randevu.builder().tarih("13.00").status(0).build();
        Randevu randevu9= Randevu.builder().tarih("13.30").status(0).build();
        Randevu randevu10= Randevu.builder().tarih("14.00").status(0).build();
        Randevu randevu11= Randevu.builder().tarih("14.30").status(0).build();
        Randevu randevu12= Randevu.builder().tarih("15.00").status(0).build();
        Randevu randevu13= Randevu.builder().tarih("15.30").status(0).build();
        Randevu randevu14= Randevu.builder().tarih("16.00").status(0).build();
        Randevu randevu15= Randevu.builder().tarih("16.30").status(0).build();
        Randevu randevu16= Randevu.builder().tarih("17.00").status(0).build();
        Randevu randevu17= Randevu.builder().tarih("17.30").status(0).build();

        randevuService.saveAll(List.of(randevu,randevu1,randevu2,randevu3,randevu4,randevu5,randevu6,randevu7,randevu8,randevu9,
        randevu10,randevu11,randevu12,randevu13,randevu14,randevu15,randevu16,randevu17));

    }
}
