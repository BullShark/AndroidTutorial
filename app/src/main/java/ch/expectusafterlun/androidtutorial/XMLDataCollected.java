package ch.expectusafterlun.androidtutorial;

import androidx.annotation.NonNull;

public class XMLDataCollected {
    float temperature = 0;
    String city = "";

    public void setCity(String city) {
        this.city = city;
    }

    public void setTemp(float temperature) {
        this.temperature = temperature;
    }

    @NonNull
    @Override
    public String toString() {
        return "In " + city + " the Current Temperature in F is " + temperature + " degrees";
    }
}
