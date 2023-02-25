package com.study.oop.movieapp;

import com.study.oop.movieapp.condition.DiscountCondition;
import com.study.oop.movieapp.condition.DiscountConditionType;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;
        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                DayOfWeek screenedDayOfWeek = screening.getWhenScreened().getDayOfWeek();
                LocalTime screenedStartTime = screening.getWhenScreened().toLocalTime();
                discountable = condition.isDiscountable(screenedDayOfWeek, screenedStartTime);
            } else {
                discountable = condition.isDiscountable(screening.getSequence());
            }

            if (discountable) break;
        }

        Money fee;
        if (discountable) {
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }

            fee = movie.getFee().minus(discountAmount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
