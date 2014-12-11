package com.momia.asg.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.momia.asg.GameTextures;

/**
 * Created by momia on 11/12/14.
 */
public class Soldier extends Actor{
    private static Animation laughingAnimation = new Animation(1/15f,GameTextures.textures.findRegions("soldier"), Animation.PlayMode.LOOP);
    private float time = 0;

    @Override
    public void draw(Batch batch,float deltaTime){
        TextureRegion region = laughingAnimation.getKeyFrame(time);
        batch.draw(region, this.getX(),this.getY(),0,0,region.getRegionWidth(),region.getRegionHeight(),1/32f,1/32f,0);
    }

    public void increaseTime(float DeltaTime){
        time += DeltaTime;
    }

}
