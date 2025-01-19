package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private String sex;
    private boolean expectedHasMane;
    private Feline felineMock;
    private Lion lion;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Тестовые данные: пол = {0}, ожидаемая грива = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Before
    public void setUp() throws Exception {
        felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getKittens()).thenReturn(3); // Мокаем метод getKittens
        lion = new Lion(sex, felineMock);
    }

    // Проверяем, что если лев самец, то у него есть грива
    @Test
    public void testDoesHaveMane() {
        assertEquals("Грива должна быть у самца.", expectedHasMane, lion.doesHaveMane());
    }
}
