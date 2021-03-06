package com.momia.asg.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.momia.asg.ASG;
import com.momia.asg.controller.desktopcontroller.DesktopTopDownPadController;
import com.momia.asg.model.Soldier;

/**
 * Created by momia on 5/12/14.
 */
public class Screen1 extends ScreenAdapter {
    private Stage stage;
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer mapRenderer;

    public Screen1(ASG game){
        ASG game1;
        game1 = game;
        camera = new OrthographicCamera(1,1);
        stage = new Stage(new FillViewport(1,(float)Gdx.graphics.getHeight()/Gdx.graphics.getWidth(),camera));
        TiledMap map = new TmxMapLoader().load("level1.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map,1/32f); //Tile size 32x32
        Soldier soldier = new Soldier(game.getControlFactory().createTopDownActorController(0));

        stage.addActor(soldier);
    }

    @Override
    public void render(float deltaTime){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        setCamera();
        stage.act(deltaTime);
        stage.getBatch().begin();
        mapRenderer.render();
        stage.getBatch().end();
        stage.draw();
    }

    @Override
    public void resize(int width,int height){
        camera.setToOrtho(false,1,(float)height/width);
    }

    private void setCamera(){
        camera.position.x = 15;
        camera.position.y = 6;
        camera.zoom = 30; //Ten tiles in the screen
        camera.update();
        mapRenderer.setView(camera);
    }
}
