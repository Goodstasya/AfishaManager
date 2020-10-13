package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;

    @InjectMocks
    private AfishaManager manager;

    Film film1 = new Film(1,1,"film1");
    Film film2 = new Film(2,2,"film2");
    Film film3 = new Film(3,3,"film3");
    Film film4 = new Film(4,4,"film4");
    Film film5 = new Film(5,5,"film5");
    Film film6 = new Film(6,6,"film6");
    Film film7 = new Film(7,7,"film7");
    Film film8 = new Film(8,8,"film8");
    Film film9 = new Film(9,9,"film9");
    Film film10 = new Film(10,10,"film10");
    Film film11 = new Film(11,11,"film11");

    @BeforeEach
    void setUp() {
        manager.save(film1);
        manager.save(film2);
        manager.save(film3);
        manager.save(film4);
        manager.save(film5);
        manager.save(film6);
        manager.save(film7);
        manager.save(film8);
        manager.save(film9);
    }

    @Test
    void shouldRemoveIfExists() {
        manager.save(film10);
        int idToRemove = 3;
        Film[] returned = new Film[]{film1, film2, film4, film5, film6, film7, film8, film9, film10};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Film[] expected = new Film[]{film10, film9, film8, film7, film6, film5, film4, film2, film1};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    void shouldGetLessThenLengthFilms() {
        Film[] returned = new Film[]{film1, film2, film3, film4, film5, film6, film7, film8, film9};
        doReturn(returned).when(repository).findAll();
        Film[] expected = new Film[]{film9, film8, film7, film6, film5, film4, film3, film2, film1};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMoreThenLengthFilms() {
        manager.save(film10);
        manager.save(film11);
        Film[] returned = new Film[]{film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        doReturn(returned).when(repository).findAll();
        Film[] expected = new Film[]{film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetEqualLengthFilms() {
        manager.save(film10);
        Film[] returned = new Film[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};
        doReturn(returned).when(repository).findAll();
        Film[] expected = new Film[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Film returned = film3;
        doReturn(returned).when(repository).findById(3);
        Film actual = manager.findById(3);
        Film expected = film3;
        assertEquals(actual, expected);
    }
}