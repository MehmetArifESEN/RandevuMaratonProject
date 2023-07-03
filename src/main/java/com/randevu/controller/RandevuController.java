package com.randevu.controller;

import com.randevu.dto.request.RandevuIptalRequestDto;
import com.randevu.dto.request.RandevuSaveRequestDto;
import com.randevu.dto.response.BosRandevuResponseDto;
import com.randevu.dto.response.RandevuListesiResponseDto;
import com.randevu.repository.entity.Randevu;
import com.randevu.service.RandevuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.randevu.constants.RestApiList.*;

@RestController
@RequestMapping(RANDEVU)
@RequiredArgsConstructor
public class RandevuController {
    private final RandevuService randevuService;

    @PostMapping(SAVE)
    public Randevu save(@RequestBody @Valid RandevuSaveRequestDto dto){
        return randevuService.save(dto);
    }
    @PostMapping(IPTAL)
    public Randevu iptal(@RequestBody @Valid RandevuIptalRequestDto dto) {
        return randevuService.iptal(dto);
    }
    @GetMapping(BOSRANDEVU)
    public List<BosRandevuResponseDto> findAllBosRandevu(){
        return randevuService.findAllBosRandevu();
    }
    @GetMapping(RANDEVULISTESI)
    public List<RandevuListesiResponseDto> findAllRandevuListesi(){
        return randevuService.findAllRandevuListesi();
    }


}
