package com.example.bomberman.Entities.Enemy.AI;

import com.example.bomberman.Entities.Balloon;
import com.example.bomberman.Entities.Bomber;
import com.example.bomberman.Entities.Bomb;

public class AIMedium2 extends AI{

    Balloon _balloon;
    Bomber _bomber;
    Bomb _bomb;

    public AIMedium2(Bomber bomber, Balloon balloon, Bomb bomb) {
        _bomber = bomber;
        _balloon = balloon;
        _bomb = bomb;
    }

    @Override
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
        if (_bomber.bomberX > _balloon.bomberX) return 1;
        if (_bomber.bomberX < _balloon.bomberX) return 3;
        return -1;
    }
    public int dicrectionCol(){
        if (_bomber.bomberY < _balloon.bomberY) return 0;
        if (_bomber.bomberY > _balloon.bomberY) return 2;
        return -1;
    }
}