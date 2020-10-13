package ru.netology.repository;

import ru.netology.domain.*;

public class AfishaRepository {
    private Film[] items = new Film[0];

    public Film[] findAll() {
        return items;
    }

    public void save(Film item) {
        int length = items.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Film findById(int id) {
        Film result = new Film();
        for (Film item : items) {
            if (item.getId() == id) {
                result = item;
            }
        }

        return result;
    }

    public void removeById (int id) {
        int length = items.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeAll () {
        items = new Film[0];
    }
}
