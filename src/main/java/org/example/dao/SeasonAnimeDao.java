package org.example.dao;

import org.example.model.SeasonAnime;

import java.util.List;

public interface SeasonAnimeDao {
    List<SeasonAnime> getAll();

    SeasonAnime getById(int id);
}
