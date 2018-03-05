package org.alexkov.bookingchecker.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainSearchResponse {
    private String error;
    private TrainSearchResult data;
}