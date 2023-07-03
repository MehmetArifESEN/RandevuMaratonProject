package com.randevu.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_SERVER_ERROR(1000,"Sunucuda Bilinmeyen bir hata oluştu", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001,"İstek formatı hatalı",HttpStatus.BAD_REQUEST),

    RANDEVUSAATI_BULUNAMADI(4002,"Randevu saati geçersiz",HttpStatus.BAD_REQUEST),
    RANDEVU_DOLU(4003,"Randevu Dolu",HttpStatus.BAD_REQUEST),
    RANDEVU_BULUNAMADI(4004,"Randevu Mevcut Değil",HttpStatus.BAD_REQUEST),

    REGISTER_KULLANICIADI_KAYITLI(1001,"Kullanıcı adı kayıtlı",HttpStatus.BAD_REQUEST),

    INVALID_TOKEN(1002,"Geçersiz token",HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatus httpStatus;
}