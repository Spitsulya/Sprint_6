package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    Alex alex;

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        alex = new Alex(feline);
    }

    // Проверяем, что конструктор создает экземпляр класса
    @Test
    public void testConstructor() throws Exception {
        assertEquals("Объект должен совпадать с классом.", alex.getClass(), Alex.class);
    }

    // Проверяем, с кем дружит Алекс
    @Test
    public void testGetFriends() throws Exception {
        List<String> expectedFriendsResult = List.of("Марти", "Глория", "Мелман");
        assertEquals("Список друзей должен совпадать с ожидаемым.", expectedFriendsResult, alex.getFriends());
    }

    // Проверяем, где живет Алекс
    @Test
    public void testGetPlaceOfLiving() {
        assertEquals("Место проживания должно совпадать с ожидаемым.","Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    // Проверяем, что у Алекса не может быть котят
    @Test
    public void testGetKittens() {
    assertEquals("Алекс не должен иметь львят.",0, alex.getKittens());
    }


}