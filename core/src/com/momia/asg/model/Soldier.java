package com.momia.asg.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.momia.asg.GameTextures;
import com.momia.asg.controller.ActorController;

/**
 * Created by momia on 11/12/14.
 */
public class Soldier extends Actor{
    private static Animation laughingAnimation = new Animation(1/15f,GameTextures.textures.findRegions("soldier"), Animation.PlayMode.LOOP);
    private ActorController actorController;
    private float time = 0;


    public Soldier(ActorController actorController) {
        this.actorController = actorController;
    }


    @Override
    public void act(float delta){
       actorController.control(this,delta);

    }

    @Override
    public void draw(Batch batch,float deltaTime){
        TextureRegion region = laughingAnimation.getKeyFrame(time/32f);
        batch.draw(region, getX(),getY(),0,0,region.getRegionWidth(),region.getRegionHeight(),getScaleX()/32f,getScaleY()/32f,0);
        increaseTime(deltaTime);
    }

    public void increaseTime(float DeltaTime){
        time += DeltaTime;
    }

}
