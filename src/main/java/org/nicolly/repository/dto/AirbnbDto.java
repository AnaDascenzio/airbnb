package org.nicolly.repository.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AirbnbDto {

    private Long id;
    private String name;
    private String neighbourhoodCleansed;
    private String price;
    private Integer numberOfReviews;
    private Double reviewScoreRating;
}
