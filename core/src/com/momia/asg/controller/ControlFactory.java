package com.momia.asg.controller;

/**
 * Created by momia on 12/13/14.Project: asg.
 */
public interface ControlFactory {
    public abstract ActorController createTopDownActorController(int controllerIndex);
}
