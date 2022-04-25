package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final String INPUT_MESSAGE_FOR_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_MESSAGE_FOR_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(INPUT_MESSAGE_FOR_CAR_NAME);

        Cars cars = new Cars();
        while (true) {

            try {
                if (cars.ready(Console.readLine())) {
                    System.out.println(INPUT_MESSAGE_FOR_TRY_COUNT);
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                RaceResult result = new RaceResult(Integer.parseInt(Console.readLine()));
                System.out.println();

                result.start(cars);
                result.showWinner(cars);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
