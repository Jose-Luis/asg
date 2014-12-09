package com.momia.asg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by momia on 5/12/14.
 */
public class Screen1 extends ScreenAdapter {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;

    public Screen1(){
        batch = new SpriteBatch();
        camera = new OrthographicCamera(10,10);
        map = new TmxMapLoader().load("level1.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map,1/32f);
    }

    @Override
    public void render(float deltaTime){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.position.x = 25;
        camera.position.y = 26;
        camera.zoom = 1f;
        camera.update();
        mapRenderer.setView(camera);
        batch.begin();
        mapRenderer.render();
        batch.end();
    }

}
