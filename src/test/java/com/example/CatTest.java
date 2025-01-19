package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    // Проверяем, что класс Cat правильно получает пищу через интерфейс Predator
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        // Проверяем, что метод getFood возвращает ожидаемый список
        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();
        assertEquals("Список пищи должен совпадать с ожидаемым", expectedFood, actualFood);
    }

    // Проверяем, что класс Cat правильно возвращает звук
    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        // Проверяем, что метод getSound возвращает "Мяу"
        assertEquals("Коты должны мяукать", "Мяу", cat.getSound());
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
//        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
//        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
//
//        // Проверяем, что метод getFood возвращает ожидаемый список
//        Cat cat = new Cat(feline);
//        List<String> actualFood = cat.getFood();
//        assertEquals(expectedFood, actualFood);
//    }