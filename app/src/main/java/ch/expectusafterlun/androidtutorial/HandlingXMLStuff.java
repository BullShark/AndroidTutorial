package ch.expectusafterlun.androidtutorial;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class HandlingXMLStuff extends DefaultHandler {

    private XMLDataCollected info = new XMLDataCollected();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if(localName.equals("city")) {
            String city = attributes.getValue("name");
            info.setCity(city);
        } else if(localName.equals("temperature")) {
            String temperature = attributes.getValue("value");
            info.setTemp(Float.parseFloat(temperature));
        }
    }

    public String getInformation() {
        return info.toString();
    }
}
