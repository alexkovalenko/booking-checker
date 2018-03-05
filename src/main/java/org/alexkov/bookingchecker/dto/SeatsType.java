package org.alexkov.bookingchecker.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeatsType {
    private String id;
    private String title;
    private String letter;
    private long places;
}
