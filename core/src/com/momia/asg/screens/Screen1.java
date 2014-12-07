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
    private AssetManager assetManager;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer mapRenderer;

    public Screen1(){
        assetManager = new AssetManager();
        batch = new SpriteBatch();
        camera = new OrthographicCamera(20,20);
        assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        assetManager.load("level1.tmx", TiledMap.class);
        mapRenderer = new OrthogonalTiledMapRenderer((TiledMap) assetManager.get("level1.tmx"),1/32f);
    }

    @Override
    public void render(float deltaTime){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.begin();
        mapRenderer.render();
        batch.end();

    }

}
