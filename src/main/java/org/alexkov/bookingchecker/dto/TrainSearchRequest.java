package org.alexkov.bookingchecker.dto;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Data
@Builder
public class TrainSearchRequest {
    private final String from;
    private final String to;
    private final String date;
    private final String time;

    public Map<String, ?> toMap() {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("from", from);
        map.add("to", to);
        map.add("date", date);
        map.add("time", time);
        return map;
    }
}
