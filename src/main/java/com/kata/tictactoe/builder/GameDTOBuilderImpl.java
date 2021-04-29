package com.kata.tictactoe.builder;

import com.kata.tictactoe.domain.Game;
import com.kata.tictactoe.dto.GameDTO;
import com.kata.tictactoe.enums.Shape;
import org.springframework.stereotype.Component;

@Component
public class GameDTOBuilderImpl implements GameDTOBuilder{
    @Override
    public GameDTO build(Game game) {
        return new GameDTO(game.getPlayers(), game.getWinner(), game.getState(), buildStateViewFrame(game.getState()));
    }

    private String buildStateViewFrame(Shape[] state) {
            return "-----------------------------------\n" +
                    "|           |          |          \n" +
                    "|    " + state[0].getValue() + "       |   " + state[1].getValue() + "     |    " + state[2].getValue() + "      \n" +
                    "|           |          |          \n" +
                    "-----------------------------------\n" +
                    "|           |          |          \n" +
                    "|    " + state[3].getValue()+ "       |   " + state[4].getValue() + "     |    " + state[5].getValue() + "      \n" +
                    "|           |          |          \n" +
                    "-----------------------------------\n" +
                    "|           |          |          \n" +
                    "|    " + state[6].getValue() + "       |   " + state[7].getValue() + "     |    " + state[8].getValue() + "      \n" +
                    "|           |          |          \n" +
                    "-----------------------------------\n";
    }
}
