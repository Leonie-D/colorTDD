package leonie.color.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColorTest {
    private Color color1;
    private Color color2;

    private final int rouge = 213;
    private final int vert = 141;
    private final int bleu = 53;
    private final String hexaColor = "#D58D35";

    @Before
    public void setUp() {
        color1 = new Color(rouge, vert, bleu);
        color2 = new Color(hexaColor);
    }

    @After
    public void tearDown() {
        color1 = null;
        color2 = null;
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_TroisArguments_Argument1Illegal_borneMax () {
        new Color(290, vert, bleu);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_TroisArguments_Argument2Illegal_borneMax () {
        new Color(rouge, 680, bleu);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_TroisArguments_Argument3Illegal_borneMax () {
        new Color(rouge, vert, 1200);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_TroisArguments_Argument1Illegal_borneMin () {
        new Color(-290, vert, bleu);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_TroisArguments_Argument2Illegal_borneMin () {
        new Color(rouge, -680, bleu);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_TroisArguments_Argument3Illegal_borneMin () {
        new Color(rouge, vert, -1200);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_UnArgument_ArgumentIllegal_diese () {
        new Color("D58D35");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_UnArgument_ArgumentIllegal_longueur () {
        new Color("#D58D3");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_UnArgument_ArgumentIllegal_longueur2 () {
        new Color("#D58D356");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_UnArgument_ArgumentIllegal_regex1 () {
        new Color("#D58P35");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_UnArgument_ArgumentIllegal_regex2 () {
        new Color("#D58!35");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testColor_UnArgument_ArgumentIllegal_regex3 () {
        new Color("#D58d35");
    }

    @Test
    public void testGetters() {
        assertEquals(rouge, color1.getRed());
        assertEquals(vert, color1.getGreen());
        assertEquals(bleu, color1.getBlue());
        assertEquals(hexaColor, color1.getHexValue());

        assertEquals(rouge, color2.getRed());
        assertEquals(vert, color2.getGreen());
        assertEquals(bleu, color2.getBlue());
        assertEquals(hexaColor, color2.getHexValue());
    }

    @Test
    public void testGetGreen() {
        assertEquals(vert, color1.getGreen());
        assertEquals(rouge, color1.getRed());
        assertEquals(bleu, color1.getBlue());
        assertEquals(hexaColor, color1.getHexValue());

        assertEquals(vert, color2.getGreen());
        assertEquals(rouge, color2.getRed());
        assertEquals(bleu, color2.getBlue());
        assertEquals(hexaColor, color2.getHexValue());
    }

    @Test
    public void testGetBlue() {
        assertEquals(bleu, color1.getBlue());
        assertEquals(rouge, color1.getRed());
        assertEquals(vert, color1.getGreen());
        assertEquals(hexaColor, color1.getHexValue());

        assertEquals(bleu, color2.getBlue());
        assertEquals(rouge, color2.getRed());
        assertEquals(vert, color2.getGreen());
        assertEquals(hexaColor, color2.getHexValue());
    }

    @Test
    public void testGetHexValue() {
        assertEquals(hexaColor, color1.getHexValue());
        assertEquals(rouge, color1.getRed());
        assertEquals(vert, color1.getGreen());
        assertEquals(bleu, color1.getBlue());

        assertEquals(hexaColor, color2.getHexValue());
        assertEquals(rouge, color2.getRed());
        assertEquals(vert, color2.getGreen());
        assertEquals(bleu, color2.getBlue());
    }

    @Test
    public void testSetRed() {
        color1.setRed(41);
        assertEquals(41, color1.getRed());
        assertEquals(vert, color1.getGreen());
        assertEquals(bleu, color1.getBlue());
        assertEquals("#298D35", color1.getHexValue());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetRed_borneMax() {
        color1.setRed(410);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetRed_borneMin() {
        color1.setRed(-10);
    }

    @Test
    public void testSetGreen() {
        color1.setGreen(41);
        assertEquals(rouge, color1.getRed());
        assertEquals(41, color1.getGreen());
        assertEquals(bleu, color1.getBlue());
        assertEquals("#D52935", color1.getHexValue());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetGreen_borneMax() {
        color1.setGreen(410);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetGreen_borneMin() {
        color1.setGreen(-10);
    }

    @Test
    public void testSetBlue() {
        color1.setBlue(41);
        assertEquals(rouge, color1.getRed());
        assertEquals(vert, color1.getGreen());
        assertEquals(41, color1.getBlue());
        assertEquals("#D58D29", color1.getHexValue());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetBlue_borneMax() {
        color1.setBlue(410);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetBlue_borneMin() {
        color1.setBlue(-10);
    }

    @Test
    public void testSetHexValue() {
        color1.setHexValue("#FFFFFF");
        assertEquals(255, color1.getRed());
        assertEquals(255, color1.getGreen());
        assertEquals(255, color1.getBlue());
        assertEquals("#FFFFFF", color1.getHexValue());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetHexValue_longueur1() {
        color1.setHexValue("#FFFFF");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetHexValue_longueur2() {
        color1.setHexValue("#FFFFFFF");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetHexValue_regex1() {
        color1.setHexValue("#MFFFFF");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetHexValue_regex2() {
        color1.setHexValue("#@FFFFF");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetHexValue_regex3() {
        color1.setHexValue("@FFFFFF");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetHexValue_regex4() {
        color1.setHexValue("#fFFFFF");
    }

    @Test
    public void testToString() {
        assertEquals("[value=#D58D35, r=213, g=141, b=53]", color1.toString());
        assertEquals(rouge, color1.getRed());
        assertEquals(vert, color1.getGreen());
        assertEquals(bleu, color1.getBlue());
        assertEquals(hexaColor, color1.getHexValue());
    }
}
