package com.example.androidgame2d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.androidgame2d.GameView.screenRatioX;
import static com.example.androidgame2d.GameView.screenRatioY;

public class flight {
    public int toShoot = 0;
    int x, y, width, height, wingCounter = 0,shootConter = 1;
    Bitmap flight1,flight2, shoot, shoot2, dead;
    private GameView gameView;

    boolean isGoingUp = false;
    flight(GameView gameView, int screenY, Resources res){
        this.gameView = gameView;
        flight1 = BitmapFactory.decodeResource(res, R.drawable.plane2);
        flight2 = BitmapFactory.decodeResource(res, R.drawable.plane1);
        width = flight1.getWidth();
        height = flight1.getHeight();

        width /= 4;
        height /= 4;

        width *=  screenRatioX;
        height *=  screenRatioY;

        flight1 = Bitmap.createScaledBitmap(flight1,width,height,false);
        flight2 = Bitmap.createScaledBitmap(flight2,width,height,false);

        shoot = BitmapFactory.decodeResource(res,R.drawable.bullet);
        shoot2 = BitmapFactory.decodeResource(res,R.drawable.bullet2);
        shoot = Bitmap.createScaledBitmap(shoot,width,height,false);
        shoot2 = Bitmap.createScaledBitmap(shoot,width,height,false);

        dead = BitmapFactory.decodeResource(res,R.drawable.dead);
        dead = Bitmap.createScaledBitmap(dead,width,height,false);

        y = screenY/2;
        x = (int)(64*screenRatioX);
    }
    Bitmap getFlight(){
        if(toShoot != 0){
            if(shootConter == 1){
                shootConter++;
                return shoot;
            }
            shootConter = 1;
            toShoot--;
            gameView.newBullet();
            return shoot2;
        }

        if(wingCounter == 0){
            wingCounter++;
            return flight2;
        }
        wingCounter--;
        return flight1;
    }
    Rect getCollissionShape(){
        return new Rect(x,y,x+width,y+height);
    }
    Bitmap getDead(){
        return dead;
    }
}
