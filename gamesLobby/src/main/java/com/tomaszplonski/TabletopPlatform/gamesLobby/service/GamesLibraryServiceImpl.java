package com.tomaszplonski.TabletopPlatform.gamesLobby.service;

import com.tomaszplonski.TabletopPlatform.gamesLobby.data.GamesLibraryEntity;
import com.tomaszplonski.TabletopPlatform.gamesLobby.model.CreateGameModel;
import com.tomaszplonski.TabletopPlatform.gamesLobby.model.GameResponseModel;
import com.tomaszplonski.TabletopPlatform.gamesLobby.model.ListOfGamesResponseModel;
import com.tomaszplonski.TabletopPlatform.gamesLobby.repository.GamesLibraryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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

    @Override
    public ListOfGamesResponseModel getAllGames(){

       List<GamesLibraryEntity> gamesFromDb = (List<GamesLibraryEntity>) gamesLibraryRepository.findAll();
       ListOfGamesResponseModel gamesForResponse = new ListOfGamesResponseModel();

       gamesFromDb.forEach(e -> gamesForResponse.addGameToList(modelMapper.map(e, GameResponseModel.class)));

       return gamesForResponse;

    }

}
