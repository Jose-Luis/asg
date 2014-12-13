package com.momia.asg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.momia.asg.ASG;
import com.momia.asg.controller.desktopcontroller.DesktopControlFactory;

import java.lang.String;

public class DesktopLauncher {
	public static void main (String[] arg) {

		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.maxWidth = 512;
		settings.maxHeight = 512;
		TexturePacker.process(settings, "images", "packedImages", "game");

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.fullscreen =true;
		config.width = 1920;
		config.height = 1080;
		config.vSyncEnabled = true;
		new LwjglApplication(new ASG(new DesktopControlFactory()), config);
	}
}
