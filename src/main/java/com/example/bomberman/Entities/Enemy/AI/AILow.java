package com.example.bomberman.Entities.Enemy.AI;

import com.example.bomberman.Entities.Bomber;
import com.example.bomberman.GamePanel;

public class AILow extends AI {

    GamePanel _gamePanel;

    public AILow(GamePanel gamePanel) {
        _gamePanel = gamePanel;
    }
    @Override
    public int calculateDirection() {
        int i;
        i = random.nextInt(2);
        return i;
    }


}
