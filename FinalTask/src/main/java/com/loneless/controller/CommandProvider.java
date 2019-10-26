package com.loneless.controller;

import com.loneless.controller.Command_imp.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();
    private static final CommandProvider commandProvider=new CommandProvider();
    private CommandProvider(){
        repository.put(CommandName.ADD_TRANSACTION,new AddTransaction());
        repository.put(CommandName.AUTHORISE_USER,new AuthoriseUser());
        repository.put(CommandName.DELETE_TRANSACTION,new DeleteTransaction());
        repository.put(CommandName.UPDATE_TRANSACTION,new UpdateTransaction());
        repository.put(CommandName.RECEIVE_ALL_TRANSACTION,new ReceiveAllTransaction());
        repository.put(CommandName.WRONG_REQUEST,new WrongRequest());
        repository.put(CommandName.CALCULATE_CURRENT_SUM,new CalculateCurrentSum());
        repository.put(CommandName.RECEIVE_PLANNED_TRANSACTION,new ReceivePlannedTransaction());
        repository.put(CommandName.FIND_OLL_TRANSACTION_TO_CURRENT_DATE,new FindOllTransactionToCurrentDate());
        repository.put(CommandName.FIND_OLL_TRANSACTION_IN_INTERVAL,new FindOllTransactionInInterval());
        repository.put(CommandName.SAVE_TRANSACTIONS,new SaveTransactions());
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
