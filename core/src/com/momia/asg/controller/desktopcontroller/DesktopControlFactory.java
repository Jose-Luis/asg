package com.momia.asg.controller.desktopcontroller;

import com.momia.asg.controller.ActorController;
import com.momia.asg.controller.ControlFactory;

/**
 * Created by momia on 12/13/14.Project: asg.
 */
public class DesktopControlFactory implements ControlFactory {

    @Override
    public ActorController createTopDownActorController(int controllerIndex) {
        return new DesktopTopDownPadController(controllerIndex);
    }
}
