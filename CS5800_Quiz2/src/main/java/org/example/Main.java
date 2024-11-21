package org.example;

interface TrafficLightState {
    void changeState(TrafficLight light);
}

//Red Light
class RedLight implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Changing from Red to Green");
        light.setState(new GreenLight());
    }
}

//Green Light
class GreenLight implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Changing from Green to Yellow");
        light.setState(new YellowLight());
    }
}

//Yellow
class YellowLight implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Changing from Yellow to Red");
        light.setState(new RedLight());
    }
}

class TrafficLight {
    public Object changeState;
    private TrafficLightState currentState;

    public TrafficLight() {
        this.currentState = new RedLight(); // Initial state
    }

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void changeState() {
        currentState.changeState(this);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        for (int i = 0; i < 3; i++) { // 5 transitions
            trafficLight.changeState();
        }
    }
}