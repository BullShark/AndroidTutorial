package ch.expectusafterlun.androidtutorial;

public class XMLDataCollected {
    int temperature = 0;
    String city = null;

    public void setCity(String city) {
        this.city = city;
    }

    public void setTemp(int temperature) {
        this.temperature = temperature;
    }

    public String getData() {
        return "In " + city + " the Current Temperature in F is " + temperature + " degrees";
    }
}
