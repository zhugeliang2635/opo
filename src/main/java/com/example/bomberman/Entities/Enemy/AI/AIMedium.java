package com.example.bomberman.Entities.Enemy.AI;

import com.example.bomberman.Entities.Bomb;
import com.example.bomberman.Entities.OneAI;
import com.example.bomberman.GamePanel;
import com.example.bomberman.Entities.Bomber;

import java.util.ArrayList;
import java.util.List;

public class AIMedium extends AI {

    Bomber _bomber;

    Bomb _bomb;

    OneAI _oneAI;

    public AIMedium(Bomber bomber, OneAI oneAI , Bomb bomb) {
        _bomber = bomber;
        _bomb = bomb;
        _oneAI = oneAI;
    }

    public int calculateDirection() {
        return findDirection();
    }

    public int findDirection() {

        int way = random.nextInt(10);
        if (way % 2 == 0) {
            int _dir = dicrectionRow();
            if (_dir != - 1) {
                return _dir;
            }
            return dicrectionCol();
        }else {
            int _dir = dicrectionCol();
            if (_dir != - 1) {
                return _dir;
            }
            return dicrectionRow();
        }
    }

    public int dicrectionRow() {
        if (_bomber.bomberX > _oneAI.bomberX) return 1;
        if (_bomber.bomberX < _oneAI.bomberX) return 3;
        return -1;
    }
    public int dicrectionCol(){
        if (_bomber.bomberY < _oneAI.bomberY) return 0;
        if (_bomber.bomberY > _oneAI.bomberY) return 2;
        return -1;
    }
}
