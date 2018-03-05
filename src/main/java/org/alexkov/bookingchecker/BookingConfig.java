package org.alexkov.bookingchecker;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "booking")
public class BookingConfig {
    private String url;
    private String from;
    private String to;
    private String date;
    private String time;
    private String trainToFind;
    private String mailRecipients;

}
