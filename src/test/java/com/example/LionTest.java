package com.example;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LionTest {

    private Feline feline;
    private Lion lion;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        feline = Mockito.mock(Feline.class);
    }

    // Проверяем, что у льва есть грива, если он самец
    @Test
    public void testLionHasManeWhenMale() throws Exception {
        lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    // Проверяем, что у льва нет гривы, если он самка
    @Test
    public void testLionDoesNotHaveManeWhenFemale() throws Exception {
        lion = new Lion("Самка", feline);
        assertTrue(!lion.doesHaveMane());
    }

    // Проверяем, что конструктор выбрасывает исключение, если пол передан неверно
    @Test(expected = Exception.class)
    public void testLionConstructorThrowsExceptionForInvalidSex() throws Exception {
        lion = new Lion("Мужской", feline);
    }

    // Проверяем, что метод getKittens без параметров возвращает 1
    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    // Проверяем, что метод getFood() возвращает ожидаемый список еды
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        lion = new Lion("Самка", feline);

        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}