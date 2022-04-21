package telega.coffe.bot.command;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
public class CommandsContainer {

    @PostConstruct
    private void setCommandsStringHashMap(){
        responseCommands.put(Commands.START, CommandsValue.START_MESSAGE);
        responseCommands.put(Commands.STOP, CommandsValue.STOP_MESSAGE);
    }

    private final HashMap<Commands, String> responseCommands = new HashMap<>();

    public void addCommand(Commands newCommand, String responseCommand){
        responseCommands.put(newCommand, responseCommand);
    }

    public String getCommand(Commands command){
        return responseCommands.get(command);
    }
}
