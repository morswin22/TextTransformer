package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Arrays;

class NumberTransformerTest {

    private static TextTransformer transformer;

    @BeforeAll
    static void setUp() {
        transformer = new NumberTransformer();
    }

    @Test
    void testOnes() {
        Assertions.assertEquals(
            "zero one two three four five six seven eight nine",
            transformer.transform("0 1 2 3 4 5 6 7 8 9")
        );
    }

    @Test
    void testNegativeOnes() {
        Assertions.assertEquals(
            "-one -two -three -four -five -six -seven -eight -nine",
            transformer.transform("-1 -2 -3 -4 -5 -6 -7 -8 -9")
        );
    }

    @Test
    void testTens() {
        Assertions.assertEquals(
            "ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen",
            transformer.transform("10 11 12 13 14 15 16 17 18 19")
        );

        Assertions.assertEquals(
            "twenty one thirty one forty one fifty one sixty one seventy one eighty one ninety one ninety",
            transformer.transform("21 31 41 51 61 71 81 91 90")
        );
    }

    @Test
    void testHundreds() {
        Assertions.assertEquals(
            "one hundred one one hundred ten one hundred eleven one hundred twenty one one hundred twenty two" +
                    " one hundred thirty one one hundred forty one one hundred fifty one one hundred sixty one " +
                    "one hundred seventy one one hundred eighty one one hundred ninety one",
            transformer.transform("101 110 111 121 122 131 141 151 161 171 181 191")
        );
    }

    @Test
    void testThousands() {
        Assertions.assertEquals(
            "one thousand one one thousand ten one thousand eleven one thousand twenty one one thousand twenty two" +
                    " one thousand thirty one one thousand forty one one thousand fifty one one thousand sixty one " +
                    "one thousand seventy one one thousand eighty one one thousand ninety one",
            transformer.transform("1001 1010 1011 1021 1022 1031 1041 1051 1061 1071 1081 1091")
        );

        Assertions.assertEquals(
            "one thousand one hundred one one thousand one hundred ten one thousand one hundred eleven" +
                    " one thousand one hundred twenty one one thousand one hundred twenty two" +
                    " one thousand one hundred thirty one one thousand one hundred forty one " +
                    "one thousand one hundred fifty one one thousand one hundred sixty one " +
                    "one thousand one hundred seventy one one thousand one hundred eighty one one thousand one hundred ninety one",
            transformer.transform("1101 1110 1111 1121 1122 1131 1141 1151 1161 1171 1181 1191")
        );
    }

    @Test
    void testTenths() {
        Assertions.assertEquals(
                "zero and one tenth zero and two tenths zero and three tenths zero and four tenths " +
                        "zero and five tenths zero and six tenths zero and seven tenths zero and eight tenths " +
                        "zero and nine tenths",
                transformer.transform("0.1 0.2 0.3 0.4 0.5 0.6 0.7 0.8 0.9")
        );
    }

    @Test
    void testHundredths() {
        Assertions.assertEquals("zero and twelve hundredths", transformer.transform("0.12"));
        Assertions.assertEquals("zero and forty seven hundredths", transformer.transform("0.47"));
        Assertions.assertEquals("zero and five tenths", transformer.transform("0.50"));

        Assertions.assertEquals(
                "zero and one hundredth zero and two hundredths zero and three hundredths zero and four hundredths " +
                        "zero and five hundredths zero and six hundredths zero and seven hundredths zero and eight hundredths " +
                        "zero and nine hundredths",
                transformer.transform("0.01 0.02 0.03 0.04 0.05 0.06 0.07 0.08 0.09")
        );
    }

    @Test
    void testWithText() {
        Assertions.assertEquals("one   one", transformer.transform("1   1"));
        Assertions.assertEquals("one   ", transformer.transform("1   "));
        Assertions.assertEquals("   one", transformer.transform("   1"));

        Assertions.assertEquals(
                "Test number one",
                transformer.transform("Test number 1")
        );

        Assertions.assertEquals(
                "Test number -one",
                transformer.transform("Test number -1")
        );
    }

    @Test
    void testInvalidFormats() {
        Assertions.assertEquals("10000.009", transformer.transform("10000.009"));
        Assertions.assertEquals("zero", transformer.transform("0.003"));
    }

    @Test
    void testDifferentFormats() {
        Assertions.assertEquals(
                "Test number one and one tenth.one",
                transformer.transform("Test number 1.1.1")
        );

        Assertions.assertEquals(
                "Test five;thirty two; twenty one-twenty one-twelve one and two tenths-four and four tenths",
                transformer.transform("Test 5;32; 21-21-12 1.2-4.4")
        );

        Assertions.assertEquals(
                "one and two tenths#one and thirty one hundredths#one and thirty one hundredths" +
                        "#three hundred twelve and fifty one hundredths#one and fifty two hundredths",
                transformer.transform("1.2#1.31#1.31#312.51#1.52")
        );
    }

    @Test
    void testPatryk() {
        Assertions.assertEquals("two thousand one hundred thirty seven and forty two hundredths", transformer.transform("2137.42"));
    }
}