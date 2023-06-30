package com.soumen.simplebilling.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soumen.simplebilling.model.MeterType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class MeterReadingHistory {
    @Id

    private String id;
    private MeterType meterType;
    private Integer meterReadingValue;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date submitDate;
    private Boolean startingReading;

}
