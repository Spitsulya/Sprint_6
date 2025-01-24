package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    private Feline feline;

    // Параметры для теста getKittens
    @Parameterized.Parameter(0)
    public int inputKittensCount;
    @Parameterized.Parameter(1)
    public int expectedKittensCount;

    @Parameterized.Parameters(name = "Тестовые данные: ФР кол-ва котят = {0}, ОР кол-ва котят = {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},  // Тест для 1 котенка
                {5, 5},  // Тест для 5 котят
                {10, 10} // Тест для 10 котят
        });
    }

    @Before
    public void setUp() {
        feline = new Feline();
    }

    // Проверяем, что метод getKittens с параметром возвращает переданное значение
    @Test
    public void testGetKittensWithParameter() {
        assertEquals("Количество котят должно совпадать с ожидаемым.", expectedKittensCount, feline.getKittens(inputKittensCount));
    }
}