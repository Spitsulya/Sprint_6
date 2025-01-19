package com.example;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {

    private Feline feline;
    private Lion lion;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        feline = Mockito.mock(Feline.class);
    }

    // Проверяем, что конструктор выбрасывает исключение, если пол передан неверно
    @Test
    public void testLionCreationWithInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Мужской", feline);
        });
        assertEquals("Сообщение об ошибке должно соответствовать ожидаемому",
                "Используйте допустимые значения пола животного - самец или самка.", exception.getMessage());
    }

    // Проверяем, что метод getKittens без параметров возвращает 1
    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        lion = new Lion("Самец", feline);
        assertEquals("Количество котят должно быть равно: 1.", 1, lion.getKittens());
    }

    // Проверяем, что метод getFood() возвращает ожидаемый список еды
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        lion = new Lion("Самка", feline);

        List<String> actualFood = lion.getFood();
        assertEquals("Список пищи должен совпадать с ожидаемым", expectedFood, actualFood);
    }
}