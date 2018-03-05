package org.alexkov.bookingchecker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainSearchResult {
    private List<TrainSearch> list;
}
