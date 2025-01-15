package com.example;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    Animal animal = Mockito.mock(Animal.class);
    Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {

        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(animal.getFood("Хищник")).thenReturn(expectedFood);

        // Проверяем, что метод eatMeat возвращает ожидаемый результат
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    // Проверяем, что метод getFamily возвращает "Кошачьи"
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    // Проверяем, что метод getKittens без параметров возвращает 1
    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    // Проверяем, что метод getKittens с параметром возвращает переданное значение
    @Test
    public void testGetKittensWithParameter() {
        int kittensCount = 5;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}