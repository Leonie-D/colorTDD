package leonie.color.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ColorParamTest {
    private int red;
    private int green;
    private int blue;
    private String hexValue;

    private Color color;

    public ColorParamTest(int red, int green, int blue, String hexValue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.hexValue = hexValue;
    }

    @Before
    public void initialize() {
        color = new Color(red, green, blue);
    }

    @Parameterized.Parameters
    public static Collection colors() {
        return Arrays.asList(new Object[][] {
                { 255, 255, 255, "#FFFFFF" },
                { 213, 141, 53, "#D58D35" },
        });
    }

    @Test
    public void testParamColor() {
        System.out.println("Parameterized Color is : r=" + red + ", g=" + green +", b=" + blue);
        assertEquals(hexValue, color.getHexValue());
    }
}
