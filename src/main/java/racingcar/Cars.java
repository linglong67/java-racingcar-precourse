package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> car;

    private final String ERROR_NO_CAR = "[ERROR] 경주할 자동차가 없습니다.";

    public Cars() {}

    public boolean ready(String carsInput) {
        if(carsInput.length() == 0) {
            throw new IllegalArgumentException(ERROR_NO_CAR);
        }

        List<Car> car = new ArrayList<>();
        for(String carName : carsInput.split(",")) {
            car.add(new Car(new CarName(carName)));
        }
        this.car = car;

        return true;
    }
}
