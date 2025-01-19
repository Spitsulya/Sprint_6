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


@RunWith(Parameterized.class)
public class LionTest {

    private Feline feline;
    private Lion lion;
    private String sex;
    private boolean expectedHasMane;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        feline = Mockito.mock(Feline.class);
    }

    // Параметризованный конструктор
    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true},   // Ожидаем, что у самца будет грива
                { "Самка", false},   // Ожидаем, что у самки не будет гривы
        });
    }

    // Проверяем, что у льва есть грива
    @Test
    public void testLionHasMane() throws Exception {
        lion = new Lion(sex, feline);
        assertEquals("Грива должна быть у самца.", expectedHasMane, lion.doesHaveMane());
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