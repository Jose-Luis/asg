package com.momia.asg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.momia.asg.screens.MainMenu;
import com.momia.asg.screens.Screen1;

public class ASG extends Game {

	@Override
	public void create () {
		this.setScreen(new Screen1());
	}

	@Override
	public void render () {
        super.render();
	}
}
