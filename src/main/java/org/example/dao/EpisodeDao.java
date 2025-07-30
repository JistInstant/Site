package org.example.dao;

import org.example.model.Episode;

import java.util.List;

public interface EpisodeDao {
    List<Episode> getEpisodesByAnimeId(int animeId);
    List<Episode> getEpisodesBySeasonAnimeId(int seasonAnimeId);
}