package racingcar.domain;

import racingcar.utils.RandomNumberForRacing;

import static racingcar.domain.Car.THRESHOLD_FORWARD_VALUE;


public class RandomValueMovingStrategy implements MovableStrategy{

    @Override
    public boolean isMovable(){
        return RandomNumberForRacing.getRandomNumberForRacing() >= THRESHOLD_FORWARD_VALUE;
    }
}
