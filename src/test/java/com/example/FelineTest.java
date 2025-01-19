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

    // Проверяем, что метод eatMeat возвращает ожидаемый результат
    @Test
    public void testEatMeat() throws Exception {

        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(animal.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    // Проверяем, что метод getFamily возвращает "Кошачьи"
    @Test

    public void testGetFamily() {
        assertEquals("Принадлежит семейству: кошачьи.", "Кошачьи", feline.getFamily());
    }

    // Проверяем, что метод getKittens без параметров возвращает 1
    @Test
    public void testGetKittens() {
        assertEquals("Количество котят должно быть равно: 1.", 1, feline.getKittens());
    }
}