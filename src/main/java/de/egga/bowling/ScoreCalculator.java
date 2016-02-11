package de.egga.bowling;

import java.util.List;

public class ScoreCalculator {

    static int calc(List<Integer> rolls) {
        int sum = 0;
        int scoreInCurrentFrame = 0;

        boolean isFirstRollInFrame = true;
        boolean isRollAfterSpare = false;
        boolean isFirstRollAfterStrike = false;
        boolean isSecondRollAfterStrike = false;


        for (Integer roll : rolls) {
            scoreInCurrentFrame += roll;
            if (isRollAfterSpare) {
                sum += roll;
                isRollAfterSpare = false;
            }
            if (isFirstRollAfterStrike){
                sum += roll;
                isFirstRollAfterStrike = false;
                isSecondRollAfterStrike = true;
            } else  if (isSecondRollAfterStrike) {
                sum += roll;
                isSecondRollAfterStrike = false;
            }
            sum += roll;


            if (isFirstRollInFrame) {
                if (scoreInCurrentFrame == 10) { // strike
                    isFirstRollAfterStrike = true;

                } else {
                    isFirstRollInFrame = false;
                }

            } else {
                if (scoreInCurrentFrame == 10) { // spare
                    isRollAfterSpare = true;
                }
                scoreInCurrentFrame = 0;
                isFirstRollInFrame = true;
            }

        }

        return sum;
    }
}
