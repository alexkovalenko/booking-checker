package org.alexkov.bookingchecker;

import lombok.AllArgsConstructor;
import org.alexkov.bookingchecker.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@AllArgsConstructor
public class BookingService {

    private final Logger logger = LoggerFactory.getLogger(BookingService.class);

    private final BookingConfig bookingConfig;
    private final BookingClient bookingClient;
    private final EmailService emailService;

    @Scheduled(fixedDelay = 90 * 1000)
    public void searchTrain() {
        TrainSearchRequest request = TrainSearchRequest.builder()
                .from(bookingConfig.getFrom())
                .to(bookingConfig.getTo())
                .date(bookingConfig.getDate())
                .time(bookingConfig.getTime())
                .build();
        TrainSearchResponse trainSearchResponse = bookingClient.searchTrain(request.toMap());
        List<TrainSearch> trainSearches = trainSearchResponse.getData().getList()
                .stream().filter(this::trainMatches)
                .collect(Collectors.toList());
        if (isEmpty(trainSearches)) {
            logger.info("Missing train {} or have no seats", bookingConfig.getTrainToFind());
        } else {
            logger.info("Found not empty train {}", bookingConfig.getTrainToFind());
            trainSearches.forEach(this::sendMail);
        }
    }

    private boolean trainMatches(TrainSearch trainSearch) {
        return bookingConfig.getTrainToFind().equalsIgnoreCase(trainSearch.getNum())
                && !isEmpty(trainSearch.getTypes());
    }

    private void sendMail(TrainSearch trainSearch) {
        emailService.sendSimpleMessage(EMail.builder()
                .from("no-reply@bookingchecker.org")
                .to(bookingConfig.getMailRecipients())
                .subject("Found tickets for: " + bookingConfig.getTrainToFind())
                .content(buildContent(trainSearch))
                .build());
    }

    private String buildContent(TrainSearch trainSearch) {
        return String.format("Found %s seats types in \"%s\" train:\n%s",
                trainSearch.getTypes().size(),
                bookingConfig.getTrainToFind(),
                trainSearch.getTypes().stream()
                        .map(SeatsType::toString)
                        .collect(Collectors.joining("\n"))
        );
    }

}
