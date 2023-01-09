package com.tomaszplonski.TabletopPlatform.gamesLobby.service;

import com.tomaszplonski.TabletopPlatform.gamesLobby.data.GamesLibraryEntity;
import com.tomaszplonski.TabletopPlatform.gamesLobby.model.CreateGameModel;
import com.tomaszplonski.TabletopPlatform.gamesLobby.repository.GamesLibraryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GamesLibraryServiceImpl implements GamesLibraryService {

    private final GamesLibraryRepository gamesLibraryRepository;
    private final ModelMapper modelMapper;

    @Override
    public GamesLibraryEntity createGame(CreateGameModel game){

        GamesLibraryEntity gamesLibraryEntity = modelMapper.map(game, GamesLibraryEntity.class);
        return gamesLibraryRepository.save(gamesLibraryEntity);

    }

}
