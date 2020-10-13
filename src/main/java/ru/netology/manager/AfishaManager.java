package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.*;

public class AfishaManager {
    private AfishaRepository repository;
    private int lenght = 10;

    public AfishaManager() { }

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int lenght)
    {
        this.repository = repository;
        this.lenght = lenght;
    }

    public void save(Film item) {
        repository.save(item);
    }

    public Film[] getAll() {
        Film[] repoFilms = repository.findAll();
        Film[] result = new Film[Math.min(repoFilms.length, lenght)];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < Math.min(repoFilms.length, lenght); i++) {
            int index = repoFilms.length - i - 1;
            result[i] = repoFilms[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Film findById(int id) {
        return repository.findById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}
