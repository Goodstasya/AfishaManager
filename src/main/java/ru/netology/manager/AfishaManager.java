package ru.netology.manager;

import ru.netology.domain.Film;

public class AfishaManager {
    private int lenght = 10;
    private Film[] items = new Film[0];

    public AfishaManager(int lenght)
    {
        this.lenght = lenght;
    }

    public AfishaManager() {

    }

    public void save(Film item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Film[] tmp = new Film[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Film[] getAll() {
        Film[] result = new Film[Math.min(items.length, lenght)];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < Math.min(items.length, lenght); i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
