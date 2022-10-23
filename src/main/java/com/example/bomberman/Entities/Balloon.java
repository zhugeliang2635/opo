package com.example.bomberman.Entities;

import com.example.bomberman.Entities.Enemy.AI.AI;
import com.example.bomberman.Entities.Enemy.AI.AILow;
import com.example.bomberman.Entities.Enemy.AI.AIMedium;
import com.example.bomberman.Entities.Enemy.AI.AIMedium2;
import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Balloon extends Entity{
    GamePanel gamePanel;

    Bomber bomber;

    Bomb bomb;
    BufferedImage up1, up2, up3, down1, down2, down3, right1, right2, right3, left1, left2, left3;

    protected int _directionballoon;

    int spriteCounter = 0;
    int spriteNum = 1;

    protected AI _ai;
    public Balloon(Bomber bomber, GamePanel gamePanel, Bomb bomb){

        this.gamePanel = gamePanel;
        setDefaultValues();
        getBalloonImage();
        direction = "DOWN";
        _ai = new AIMedium2(bomber, this, bomb);

        solidArea = new Rectangle();
        solidArea.x = 10;
        solidArea.y = 10;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 20;
        solidArea.height = 28;
    }

    public void setDefaultValues(){
        bomberX = 400;
        bomberY = 400;
        speed = 5;
    }


    public void getBalloonImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_right1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_right2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_right3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_left1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_left2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_left3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_right3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_left3.png"));
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public void update(Object object){
        if( _directionballoon == 0 || _directionballoon == 1
                || _directionballoon == 2 || _directionballoon == 3) {
            if (_directionballoon == 0) {
                direction = "UP";
            } else if (_directionballoon == 1) {
                direction = "RIGHT";
            } else if (_directionballoon == 2) {
                direction = "DOWN";
            } else if (_directionballoon == 3) {
                direction = "LEFT";
            }

            // viet ham xu ly va cham vao day

            //check tile collision
            collisionOn = false;
            gamePanel.checkCollision.checkTile(this);

            if(collisionOn == true) {
                _directionballoon = _ai.calculateDirection();
            }

            //check item collision
//            int itemIndex = gamePanel.checkCollision.checkItem(this, true);

            if(collisionOn == false) {
                switch (direction){
                    case "UP": {
                        bomberY -= speed;
                        if(object.mapObjectNum[(bomberY)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE] == 5){
                            object.mapObjectNum[(bomberY)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE] = 0;
                        }
                        if(object.mapObjectNum[bomberY/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] == 6){
                            object.mapObjectNum[bomberY/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] = 0;
                        }
                        if(object.mapObjectNum[bomberY/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] == 7){
                            object.mapObjectNum[bomberY/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] = 0;
                            speed += 2;
                        }
                        break;
                    }
                    case "DOWN": {
                        bomberY += speed;
                        if(object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE/2 )/gamePanel.SCALED_SIZE] == 5){
                            object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE/2 )/gamePanel.SCALED_SIZE] = 0;
                        }
                        if(object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] == 6){
                            object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] = 0;
                        }
                        if(object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] == 7){
                            object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] = 0;
                            speed += 2;
                        }
                        break;
                    }
                    case "LEFT": {
                        bomberX -= speed;
                        if(object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX)/gamePanel.SCALED_SIZE] == 5){
                            object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX)/gamePanel.SCALED_SIZE] = 0;
                        }
                        if(object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX)/gamePanel.SCALED_SIZE]== 6){
                            object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX)/gamePanel.SCALED_SIZE] = 0;
                        }
                        if(object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX)/gamePanel.SCALED_SIZE] == 7){
                            object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX)/gamePanel.SCALED_SIZE] = 0;
                            speed += 2;;
                        }
                        break;
                    }
                    case "RIGHT": {
                        bomberX += speed;
                        if(object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE] == 5){
                            object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE] = 0;
//                            System.out.println("right");
                        }
                        if(object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE]== 6){
                            object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE] = 0;
                        }
                        if(object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE] == 7){
                            object.mapObjectNum[(bomberY + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(bomberX + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE] = 0;
                            speed += 2;
                        }
                        break;
                    }
                }
            }

            spriteCounter++;
            if (spriteCounter >= 6) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void render(Graphics2D g2){
        BufferedImage image = null;
        switch (direction) {
            case "UP" -> {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                break;
            }
            case "DOWN" -> {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                break;
            }
            case "LEFT" -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
                break;
            }
            case "RIGHT" -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;

                }
                break;
            }
        }
        g2.drawImage(image, bomberX, bomberY,GamePanel.SCALED_SIZE, GamePanel.SCALED_SIZE, null);
    }
}
