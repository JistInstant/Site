package org.example.dao;


import org.example.model.Anime;

import java.util.List;

//Определят методы для работы с таблицей anime
public interface AnimeDao {
    /*  возвращает список всех аниме из БД */
    List<Anime> getAll();
    /*  вООЗВРАЩАЕТ ОДНО АНИМЕ ПО ЕГО ID   */
    Anime getById(int id);
}

