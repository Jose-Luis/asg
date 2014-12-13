package com.momia.asg.controller.desktopcontroller;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.controllers.Controllers;
import com.momia.asg.controller.ActorController;

/**
 * Created by momia on 12/12/14.Project: asg.
 */
public class DesktopTopDownPadController implements ActorController {
    Controller padController;

    public DesktopTopDownPadController(int index)
    {
        padController = Controllers.getControllers().get(index);
    }
    @Override
    public void control(Actor actor,float deltatime) {
        float axisX = (float) ((padController.getAxis(0)-0.2)/24);
        float axisY = padController.getAxis(1)/-24;
        actor.moveBy(axisX,axisY);
    }
}
