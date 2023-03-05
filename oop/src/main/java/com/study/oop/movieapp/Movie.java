package com.study.oop.movieapp;

import com.study.oop.movieapp.condition.DiscountCondition;
import com.study.oop.movieapp.condition.DiscountConditionType;
import com.study.oop.movieapp.condition.PeriodCondition;
import com.study.oop.movieapp.condition.SequenceCondition;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<PeriodCondition> periodConditions;
    private List<SequenceCondition> sequenceConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public boolean calculateMovieFee(Screening screening) {
        return checkPeriodConditions(screening) || checkSequenceConditions(screening);
    }

    private boolean checkPeriodConditions(Screening screening) {
        return periodConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private boolean checkSequenceConditions(Screening screening) {
        return sequenceConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    private Money calculatePercentDiscountAmount(){
        return fee.times(discountPercent);
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }
}
