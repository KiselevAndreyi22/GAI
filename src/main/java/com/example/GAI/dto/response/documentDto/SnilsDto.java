package com.example.GAI.dto.response.documentDto;

import com.example.GAI.model.documentModel.Snils;
import lombok.Data;

@Data
public class SnilsDto {
    private String number;

    public SnilsDto(Snils snils){
        this.number = snils.getNumber();
    }

}
