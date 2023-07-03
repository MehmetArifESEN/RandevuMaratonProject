package com.randevu.exceptions;

import lombok.Getter;

/**
 * Bu kısımda uygulamanız içinde oluşabilecek tüm hataları kapsayan bir kapsayıcıya ihtiyacınız var,
 * yani hata tiplerini listesini içeren bir  Enum sınıfı oluşturabilirsiniz.
 * Ayrica, uygulamanız restApi krugusunda oldupu için bu hataların ResponseBody şeklinde bir entity olarak dönmek doğru olacaktır.
 * Bu nedenle bir Returntype
 */
@Getter
public class HastaneRandevuException extends RuntimeException{
    private final ErrorType errorType;
    public HastaneRandevuException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public HastaneRandevuException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }


}
