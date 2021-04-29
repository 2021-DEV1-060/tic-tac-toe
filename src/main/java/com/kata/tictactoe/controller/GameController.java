package com.kata.tictactoe.controller;

import com.kata.tictactoe.dto.GameDTO;
import com.kata.tictactoe.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.kata.tictactoe.enums.PlayerType.USER;

@RestController
@RequestMapping("/tic-tac-toe")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping("/who_goes_first")
    public GameDTO indicateWhoStartsFirst(@RequestParam("user_goes_first") boolean userGoesFirst) {
        return gameService.setUp(userGoesFirst);
    }

    @GetMapping("/user_chooses")
    public GameDTO registerUsersChoice(@RequestParam("chosen_step") int chosenStep) {
        return gameService.updateGame(USER, chosenStep);
    }
}
