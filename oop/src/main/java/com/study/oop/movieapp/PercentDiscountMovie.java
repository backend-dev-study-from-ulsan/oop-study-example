package com.study.oop.movieapp;

import com.study.oop.movieapp.condition.DiscountCondition;
import java.time.Duration;
import java.util.List;

public class PercentDiscountMovie extends Movie{
    private double percent;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee,
        List<DiscountCondition> discountConditions,
        double percent) {
        super(title, runningTime, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
