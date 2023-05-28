package com.example.Splitwise.commands;

public interface Command {

    boolean canExecute(String input);
    void execute(String input);
}
