package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class LionTest {

    private Feline feline;
    private Lion lion;
    private String sex;
    private boolean expectedHasMane;
    private boolean shouldThrowException;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        feline = Mockito.mock(Feline.class);
    }

    // Параметризованный конструктор
    public LionTest(String sex, boolean expectedHasMane, boolean shouldThrowException) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.shouldThrowException = shouldThrowException;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true, false },   // Ожидаем, что у самца будет грива
                { "Самка", false, false },   // Ожидаем, что у самки не будет гривы
                { "Мужской", false, true }   // Ожидаем выброс исключения
        });
    }

    // Проверяем, что у льва есть грива/нет гривы/исключение
    @Test
    public void testLionHasMane() throws Exception {
        if (shouldThrowException) {
            try {
                lion = new Lion(sex, feline);
            } catch (Exception e) {
                assertTrue(e instanceof Exception); // Проверяем, что выброшено исключение
                return;
            }
            // Если исключение не выброшено, тест должен завершиться неудачей
            assertTrue("Ожидалось исключение", false);
        } else {
            lion = new Lion(sex, feline);
            assertEquals(expectedHasMane, lion.doesHaveMane());
        }
    }

    // Проверяем, что конструктор выбрасывает исключение, если пол передан неверно
//    @Test(expected = Exception.class)
//    public void testLionConstructorThrowsExceptionForInvalidSex() throws Exception {
//        lion = new Lion("Мужской", feline);
//    }


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