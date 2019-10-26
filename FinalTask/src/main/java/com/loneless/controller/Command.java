package com.loneless.controller;


import com.loneless.view.ViewException;

public interface Command {
    boolean execute() throws ViewException, ControllerException;
}
