package com.momia.asg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;

/**
 * Created by momia on 5/12/14.
 */
public class Screen1 extends ScreenAdapter {
    private Stage stage;
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer mapRenderer;

    public Screen1(){
        camera = new OrthographicCamera(1,1);
        stage = new Stage(new FillViewport(1,(float)Gdx.graphics.getHeight()/Gdx.graphics.getWidth(),camera));
        TiledMap map = new TmxMapLoader().load("level1.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map,1/32f); //Tile size 32x32
    }

    @Override
    public void render(float deltaTime){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        setCamera();
        stage.getBatch().begin();
        mapRenderer.render();
        stage.getBatch().end();
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
