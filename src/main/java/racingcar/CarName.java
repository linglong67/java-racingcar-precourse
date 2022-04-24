package racingcar;

public class CarName {
    private final int MAX_NAME_LENGTH = 5;
    private final String ERROR_MAX_NAME_LENGTH = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";

    private String name;

    public CarName(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MAX_NAME_LENGTH);
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
