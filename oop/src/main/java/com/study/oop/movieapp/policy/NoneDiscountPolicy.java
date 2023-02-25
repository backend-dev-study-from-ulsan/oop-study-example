package com.study.oop.movieapp.policy;

import com.study.oop.movieapp.Money;
import com.study.oop.movieapp.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
