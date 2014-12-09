package com.momia.asg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.momia.asg.ASG;
import java.lang.String;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.fullscreen =true;
		config.width = 720;
		config.height = 1280;
		config.vSyncEnabled = true;
		new LwjglApplication(new ASG(), config);
	}
}
