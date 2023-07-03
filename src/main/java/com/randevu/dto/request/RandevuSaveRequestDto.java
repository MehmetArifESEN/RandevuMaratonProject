package com.randevu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RandevuSaveRequestDto {
    String hastaadi;
    String telefon;
    String tarih;
}
