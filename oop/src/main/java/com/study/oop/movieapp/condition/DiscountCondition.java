package com.study.oop.movieapp.condition;

import com.study.oop.movieapp.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
