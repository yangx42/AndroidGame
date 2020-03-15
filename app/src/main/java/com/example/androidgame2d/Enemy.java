package com.example.androidgame2d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.androidgame2d.GameView.screenRatioX;
import static com.example.androidgame2d.GameView.screenRatioY;

public class Enemy {
    public int speed = 20;
    public boolean wasShot = true;
    int x,y,width,height,enemyCounter = 1;
    Bitmap enemy1,enemy2,enemy3,enemy4;
    Enemy(Resources res){
        enemy1 = BitmapFactory.decodeResource(res,R.drawable.bomber);
        enemy2 = BitmapFactory.decodeResource(res,R.drawable.fighter);
        enemy3 = BitmapFactory.decodeResource(res,R.drawable.scout);
        enemy4 = BitmapFactory.decodeResource(res,R.drawable.worker);

        width/=6;
        height/=6;

        width *= (int)screenRatioX;
        height *= (int)screenRatioY;

        enemy1 = Bitmap.createScaledBitmap(enemy1,width,height,false);
        enemy2 = Bitmap.createScaledBitmap(enemy2,width,height,false);
        enemy3 = Bitmap.createScaledBitmap(enemy3,width,height,false);
        enemy4 = Bitmap.createScaledBitmap(enemy4,width,height,false);
        y = -height;
    }
    Bitmap getEnemy(){
        if(enemyCounter == 1){
            enemyCounter++;
            return enemy1;
        }
        if(enemyCounter == 2){
            enemyCounter++;
            return enemy2;
        }
        if(enemyCounter == 3){
            enemyCounter++;
            return enemy3;
        }
        enemyCounter = 1;
        return enemy4;
    }
    Rect getCollissionShape(){
        return new Rect(x,y,x+width,y+height);
    }
}
