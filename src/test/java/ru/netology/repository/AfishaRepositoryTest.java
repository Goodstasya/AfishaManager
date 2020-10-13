package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();

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

    @BeforeEach
    void setUp() {
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);
        repository.save(film6);
        repository.save(film7);
        repository.save(film8);
        repository.save(film9);
    }

    @Test
    void shouldFindAll() {
        Film[] expected = new Film[] {film1, film3, film4, film5, film6, film7, film8, film9};
        repository.removeById(2);
        Film[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSsave() {
        repository.save(film10);
        Film[] expected = new Film[] {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};
        Film[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindById() {
        Film expected = film3;
        Film actual = repository.findById(3);
        assertEquals(actual, expected);
    }

    @Test
    void shouldRemoveById() {
        Film[] expected = new Film[] {film1, film2, film3, film4, film5, film6, film7, film8, film9};
        Film[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldRemoveAll() {
        int expectedLen = 0;
        repository.removeAll();
        int actualLen = repository.findAll().length;
        assertEquals(expectedLen, actualLen);
    }
}