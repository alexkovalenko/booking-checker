package org.alexkov.bookingchecker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EMail {
    private String from;
    private String to;
    private String subject;
    private String content;
}
