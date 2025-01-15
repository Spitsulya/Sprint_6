package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
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
        assertEquals("Кошачьи", feline.getFamily());
    }

    // Проверяем, что метод getKittens без параметров возвращает 1
    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    // Параметры для теста getKittens
    @Parameterized.Parameter(0)
    public int inputKittensCount;

    @Parameterized.Parameter(1)
    public int expectedKittensCount;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},  // Тест для 1 котенка
                {5, 5},  // Тест для 5 котят
                {10, 10} // Тест для 10 котят
        });
    }

    // Проверяем, что метод getKittens с параметром возвращает переданное значение
    @Test
    public void testGetKittensWithParameter() {
        assertEquals(expectedKittensCount, feline.getKittens(inputKittensCount));
    }
}