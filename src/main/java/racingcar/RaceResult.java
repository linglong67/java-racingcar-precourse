package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    public static final String ERROR_MOVE_COUNT = "[ERROR] 1 이상의 이동 횟수를 입력해주세요.";
    public static final String RACE_RESULT = "실행 결과";
    public static final String RACE_WINNER = "최종 우승자: ";

    private int operateTime;
    private int maxRun;
    private List<String> winner;
    private boolean gameEnd;

    public RaceResult(int operateTime) {
        if(operateTime < 0) {
            throw new IllegalArgumentException(ERROR_MOVE_COUNT);
        }
        this.operateTime = operateTime;
        this.gameEnd = false;
    }

    public void start(Cars cars) {
        System.out.println(RACE_RESULT);
        for(int i=0; i<this.operateTime; i++) {
            racing(i, cars);
        }
    }

    private void racing(int operate, Cars cars) {
        cars.getCar().forEach(car -> {
            car.operate(Randoms.pickNumberInRange(0, 9));
            car.carLocation(car.getRun());
        });
        System.out.println();

        if(operate == this.operateTime - 1) {
            this.gameEnd = true;
        }
    }

    public boolean isGameEnd() {
        return this.gameEnd;
    }

    public void showWinner(Cars cars) {
        this.maxRun = 0;
        cars.getCar().forEach(car -> getMaxRun(car));

        System.out.print(RACE_WINNER);
        this.winner = new ArrayList<>();
        cars.getCar().forEach(car -> getWinner(car));

        System.out.print(String.join(", ", this.winner));
    }

    private void getMaxRun(Car car) {
        if(car.getRun() >= this.maxRun) {
            this.maxRun = car.getRun();
        }
    }

    private void getWinner(Car car) {
        if(car.getRun() == this.maxRun) {
            this.winner.add(car.getCarName().getName());
        }
    }
}
