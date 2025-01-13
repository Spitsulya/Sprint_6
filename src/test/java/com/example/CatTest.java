package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

// тесты, которые проверят, что класс Cat правильно возвращает звук и получает пищу через интерфейс Predator
@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        // Проверяем, что метод getFood возвращает ожидаемый список
        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        // Проверяем, что метод getSound возвращает "Мяу"
        assertEquals("Мяу", cat.getSound());
    }
}



//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//    Feline feline = Mockito.mock(Feline.class);
//
//    @Test
//        public void testGetFood() throws Exception {
//        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");
//        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
//
//        // Проверяем, что метод getFood возвращает ожидаемый список
//        Cat cat = new Cat(feline);
//        List<String> actualFood = cat.getFood();
//        assertEquals(expectedFood, actualFood);
//    }