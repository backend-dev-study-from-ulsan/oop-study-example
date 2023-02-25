package com.study.oop.movieapp;

import com.study.oop.movieapp.condition.DiscountCondition;
import com.study.oop.movieapp.condition.DiscountConditionType;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = movie.isDiscountable(screening.getWhenScreened(), screening.getSequence());

        Money fee = Money.ZERO;
        if (discountable) {
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    fee = movie.calculateAmountDiscountedFee();
                    break;
                case PERCENT_DISCOUNT:
                    fee = movie.calculatePercentDiscountedFee();
                    break;
                case NONE_DISCOUNT:
                    fee = movie.calculateNoneDiscountedFee();
                    break;
            }
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
