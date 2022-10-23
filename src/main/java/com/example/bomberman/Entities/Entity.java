package com.example.bomberman.Entities;

import com.example.bomberman.graphics.Sprites;

import java.awt.*;


public class Entity {

    protected double _x, _y;
    public int speed;
    public String direction;

    public Rectangle solidArea;

    public int bomberX, bomberY;
    public boolean collisionOn = false;

    public int solidAreaDefaultX;
    public int solidAreaDefaultY;

}
