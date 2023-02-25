package com.study.oop.movieapp.policy;

import com.study.oop.movieapp.Money;
import com.study.oop.movieapp.Screening;
import com.study.oop.movieapp.condition.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions;

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
//        for (DiscountCondition each : conditions) {
//            if (each.isSatisfiedBy(screening)) {
//                return getDiscountAmount(screening);
//            }
//        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
