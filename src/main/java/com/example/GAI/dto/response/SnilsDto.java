package com.example.GAI.dto.response;

import com.example.GAI.model.Snils;
import lombok.Data;

@Data
public class SnilsDto {
    private Long number;

    public SnilsDto(Snils snils){
        this.number = snils.getNumber();
    }

}
