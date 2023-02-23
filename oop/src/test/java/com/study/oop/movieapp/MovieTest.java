package com.study.oop.movieapp;

import com.study.oop.movieapp.condition.PeriodCondition;
import com.study.oop.movieapp.condition.SequenceCondition;
import com.study.oop.movieapp.policy.AmountDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

class MovieTest {

    @DisplayName("Movie가 할인정책에 따라 요금을 계산한다.")
    @Test
    void createMovie() {
        // Given
        Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000),
                                new AmountDiscountPolicy(Money.wons(800),
                                        new SequenceCondition(1),
                                        new SequenceCondition(10),
                                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0), LocalTime.of(20,59))));
        Screening todayFirstScreen = new Screening(avatar, 1, LocalDateTime.now());

        // When
        Money fee = avatar.calculateMovieFee(todayFirstScreen);

        // Then
        Assertions.assertEquals(Money.wons(10000 - 800), fee);
    }
}
