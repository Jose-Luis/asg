package com.momia.asg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.momia.asg.controller.ControlFactory;
import com.momia.asg.screens.MainMenu;
import com.momia.asg.screens.Screen1;

public class ASG extends Game {

	private ControlFactory controlFactory;

	public ASG(ControlFactory controlFactory){
		this.controlFactory = controlFactory;
	}

	@Override
	public void create () {

		int i = 0;
        for (Controller controller : Controllers.getControllers()) {
			System.out.printf("#" + i++ + ": " + controller.getName());
		}
		if (Controllers.getControllers().size == 0) System.out.printf("No controllers attached");

		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
        super.render();
	}
	public ControlFactory getControlFactory(){
		return this.controlFactory;
	}
}
