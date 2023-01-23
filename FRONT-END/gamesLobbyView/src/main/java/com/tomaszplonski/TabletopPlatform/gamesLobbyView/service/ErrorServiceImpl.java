package com.tomaszplonski.TabletopPlatform.gamesLobbyView.service;

import com.tomaszplonski.TabletopPlatform.gamesLobbyView.errors.ErrorMessageGeneric;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ErrorServiceImpl implements ErrorService {

    @Override
    public void setErrorAttribute(Model model, String errorMessage){
        model.addAttribute("error", new ErrorMessageGeneric(errorMessage));
    }

}
