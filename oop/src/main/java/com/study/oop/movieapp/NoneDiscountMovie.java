package com.study.oop.movieapp;

import com.study.oop.movieapp.condition.DiscountCondition;
import java.time.Duration;
import java.util.List;

public class NoneDiscountMovie extends Movie {

    public NoneDiscountMovie(String title, Duration runningTime, Money fee,
        List<DiscountCondition> discountConditions) {
        super(title, runningTime, fee, discountConditions);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
