package com.mobilapi.service.util;


import com.mobilapi.domain.order.Score;

public class CalculateCurrentScore {

    public static long Calculate(Score score) {

        long restaurant_score = 3;
                //score.getPresentation() + score.getTaste() + score.getVelocity();

        return restaurant_score / 3;
    }
}
