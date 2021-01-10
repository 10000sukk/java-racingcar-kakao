package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carsList;
    private MovableStrategy movableStrategy;

    public Cars(List<Car> cars) {
        this.carsList = cars;
    }

    public void moveAll() {
        for(Car car: carsList){
            car.move(movableStrategy);
        }
    }

    public void setMovableStrategy(MovableStrategy movableStrategy){
        this.movableStrategy = movableStrategy;
    }

    public Map<String, Integer> getCarsInfo() {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : carsList) {
            result.put(car.getName(), car.getPosition());
        }
        return result;
    }

    public int getNumberOfCars() {
        return this.carsList.size();
    }

    public List<String> getWinnerName() {
        return getWinner()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> getWinner() {
        int maxPosition = getMaxPosition();

        return carsList
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carsList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(java.util.NoSuchElementException::new);
    }
}
