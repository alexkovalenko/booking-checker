package org.alexkov.bookingchecker;

import feign.Headers;
import org.alexkov.bookingchecker.dto.TrainSearchResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "booking", url = "${booking.url}", configuration = BookingClientConfig.class)
public interface BookingClient {

    @RequestMapping(method = RequestMethod.POST, value = "/train_search/",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    TrainSearchResponse searchTrain(Map<String, ?> trainSearchRequest);
}
