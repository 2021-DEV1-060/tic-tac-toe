package com.kata.tictactoe;

import com.kata.tictactoe.domain.Game;
import com.kata.tictactoe.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.kata.tictactoe.enums.PlayerType.USER;

@RestController("/")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping("/who_starts_first")
    public Game indicateWhoStartsFirst(@RequestParam("user_goes_first") boolean userGoesFirst) {
        return gameService.setUp(userGoesFirst);
    }

    @GetMapping("/user_chooses")
    public Game registerUsersChoice(@RequestParam("chosen_step") int chosenStep) {
        return gameService.play(USER, chosenStep);
    }
}
