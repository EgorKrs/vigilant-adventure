package com.loneless.controller;

import com.loneless.controller.Command_imp.AddTransaction;
import com.loneless.controller.Command_imp.AutorisateUser;
import com.loneless.controller.Command_imp.DeliteTransaction;
import com.loneless.controller.Command_imp.UpdateTransaction;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();
    private static final CommandProvider commandProvider=new CommandProvider();
    private CommandProvider(){
        repository.put(CommandName.ADD_TRANSACTION,new AddTransaction());
        repository.put(CommandName.AUTHORISE_USER,new AutorisateUser());
        repository.put(CommandName.DELETE_TRANSACTION,new DeliteTransaction());
        repository.put(CommandName.UPDATE_TRANSACTION,new UpdateTransaction());
    }

    public Map<CommandName, Command> getRepository() {
        return repository;
    }

    public static CommandProvider getCommandProvider() {
        return commandProvider;
    }
    public Command getCommand(String name){
        CommandName commandName=null;
        Command command=null;
        name=name.replace(" ","_");
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }
        catch (IllegalArgumentException|NullPointerException e){
            command=repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
