package org.nicolly.model.entity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airbnb_listings")
public class Airbnb extends PanacheEntityBase {

    @Id
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "neighbourhood_cleansed")
    public String neighbourhoodCleansed;

    @Column(name = "price")
    public String price;

    @Column(name = "number_of_reviews")
    public Integer numberOfReviews;

    @Column(name = "review_scores_rating")
    public Double reviewScoreRating;
}