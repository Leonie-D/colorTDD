package leonie.color.model;

import java.util.Locale;

public class Color {
    private int red;
    private int green;
    private int blue;
    private String hexValue;

    public Color(int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);

        setHexValue(getHexValueFromColors());
    }

    public Color(String hexaColor) {
        setHexValue(hexaColor);
        setRed(Integer.parseInt(hexaColor.substring(1, 3), 16));
        setGreen(Integer.parseInt(hexaColor.substring(3, 5), 16));
        setBlue(Integer.parseInt(hexaColor.substring(5), 16));
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setRed(int red) throws IllegalArgumentException {
        if(red < 0 || red > 255) {
            throw new IllegalArgumentException("Un entier entre 0 et 255 inclus est attendu");
        } else {
            this.red = red;
            this.hexValue = getHexValueFromColors();
        }
    }

    public void setGreen(int green) throws IllegalArgumentException {
        if(green < 0 || green > 255) {
            throw new IllegalArgumentException("Un entier entre 0 et 255 inclus est attendu");
        } else {
            this.green = green;
            this.hexValue = getHexValueFromColors();
        }
    }

    public void setBlue(int blue) throws IllegalArgumentException {
        if(blue < 0 || blue > 255) {
            throw new IllegalArgumentException("Un entier entre 0 et 255 inclus est attendu");
        } else {
            this.blue = blue;
            this.hexValue = getHexValueFromColors();
        }
    }

    public void setHexValue(String hexValue) throws IllegalArgumentException {
        if(hexValue != null && hexValue.matches("^#([A-F0-9]{6})")) {
            this.hexValue = hexValue;
            red = Integer.parseInt(hexValue.substring(1, 3), 16);
            green = Integer.parseInt(hexValue.substring(3, 5), 16);
            blue = Integer.parseInt(hexValue.substring(5), 16);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "[value=" + hexValue + ", r=" + red + ", g=" + green +", b=" + blue + "]";
    }

    private String getHexValueFromColors() {
        String redHex = Integer.toHexString(red).toUpperCase();
        String greenHex = Integer.toHexString(green).toUpperCase();
        String blueHex = Integer.toHexString(blue).toUpperCase();
        return "#" + redHex + greenHex + blueHex;
    }
}
