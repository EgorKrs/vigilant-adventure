package com.loneless.controller;

import java.io.IOException;

public interface Command {
    boolean execute() throws IOException, ClassNotFoundException;
}
