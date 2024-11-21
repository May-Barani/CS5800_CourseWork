package org.example;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {

    interface ObserverVehicle {
        void update(String lightColor);
    }

    interface Subject {
        void addObserver(ObserverVehicle vehicle);
        void notifyObservers();
    }

    class TrafficLight implements Subject {
        private List<ObserverVehicle> vehicles = new ArrayList<>();
        private TrafficLightState currentState;

        public TrafficLight() {
            this.currentState = new RedLight(); // Initial state
        }

        public void setState(TrafficLightState state) {
            this.currentState = state;
            notifyObservers(); // Notify observers
        }

        public void changeState() {
            currentState.changeState(this);
        }

        @Override
        public void addObserver(ObserverVehicle vehicle) {
            vehicles.add(vehicle);
        }

        @Override
        public void notifyObservers() {
            for (ObserverVehicle vehicle : vehicles) {
                vehicle.update(currentState.getClass().getSimpleName());
            }
        }
    }
    abstract class TrafficLightState {
        public abstract void changeState(TrafficLight light);
    }

    //Red Light
    class RedLight extends TrafficLightState {
        @Override
        public void changeState(TrafficLight light) {
            System.out.println("Changing from Red to Green");
            light.setState(new GreenLight());
        }
    }

    //Green Light
    class GreenLight extends TrafficLightState {
        @Override
        public void changeState(TrafficLight light) {
            System.out.println("Changing from Green to Yellow");
            light.setState(new YellowLight());
        }
    }

    //Yellow Light
    class YellowLight extends TrafficLightState {
        @Override
        public void changeState(TrafficLight light) {
            System.out.println("Changing from Yellow to Red");
            light.setState(new RedLight());
        }
    }

    //Concrete Observer
    static class Vehicle implements ObserverVehicle {
        private final String name;

        public Vehicle(String name) {
            this.name = name;
        }

        @Override
        public void update(String lightColor) {
            System.out.println(name + " observes: Traffic light changed to " + lightColor);
        }
    }

    // Main Class
    public static class Main {
        public static void main(String[] args) {
            ObserverDesignPattern designPattern = new ObserverDesignPattern();
            TrafficLight trafficLight = designPattern.new TrafficLight();

            //vehicles as observers
            ObserverVehicle car1 = new Vehicle("Car 1");
            ObserverVehicle car2 = new Vehicle("Car 2");
            trafficLight.addObserver(car1);
            trafficLight.addObserver(car2);

            //traffic light transitions
            for (int i = 0; i < 3; i++) {
                trafficLight.changeState();
            }
        }
    }
}
