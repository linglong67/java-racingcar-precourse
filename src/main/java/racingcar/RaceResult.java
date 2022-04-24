package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceResult {

    public static final String ERROR_MOVE_COUNT = "[ERROR] 1 이상의 이동 횟수를 입력해주세요.";
    public static final String RACE_RESULT = "실행 결과";

    private int operateTime;

    public RaceResult(int operateTime) {
        if(operateTime < 0) {
            throw new IllegalArgumentException(ERROR_MOVE_COUNT);
        }
        this.operateTime = operateTime;
    }

    public void start(Cars cars) {
        System.out.println(RACE_RESULT);
        for(int i=0; i<this.operateTime; i++) {
            race(cars);
        }
    }

    private void race(Cars cars) {
        cars.getCar().forEach(car -> {
            car.operate(Randoms.pickNumberInRange(0, 9));
            car.carLocation(car.getRun());
        });
        System.out.println();
    }


    public boolean isGameEnd() {
        return false;
    }
}
