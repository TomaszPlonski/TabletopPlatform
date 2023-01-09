package com.tomaszplonski.TabletopPlatform.gamesLobby.repository;

import com.tomaszplonski.TabletopPlatform.gamesLobby.data.GamesLibraryEntity;
import org.springframework.data.repository.CrudRepository;

public interface GamesLibraryRepository extends CrudRepository<GamesLibraryEntity, Long> {
}
