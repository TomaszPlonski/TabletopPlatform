package com.tomaszplonski.TabletopPlatform.gamesLobbyView.service;

import com.tomaszplonski.TabletopPlatform.gamesLobbyView.errors.ErrorMessage;
import org.springframework.ui.Model;

public interface ErrorService {
    void setErrorAttribute(Model model, String errorMessage);
}
