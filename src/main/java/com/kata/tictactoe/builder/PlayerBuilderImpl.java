package com.kata.tictactoe.builder;

import com.kata.tictactoe.domain.Player;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.kata.tictactoe.enums.PlayerType.CPU;
import static com.kata.tictactoe.enums.PlayerType.USER;
import static com.kata.tictactoe.enums.Shape.CIRCLE;
import static com.kata.tictactoe.enums.Shape.CROSS;

@Component
public class PlayerBuilderImpl implements PlayerBuilder{
    public Set<Player> buildPlayers(boolean userWantsToGoFirst) {
        if (userWantsToGoFirst) {
            return Set.of(
                    new Player(USER, CROSS),
                    new Player(CPU, CIRCLE)
            );
        }
        return Set.of(
                new Player(CPU, CROSS),
                new Player(USER, CIRCLE)
        );
    }
}
