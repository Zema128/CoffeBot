package telega.coffe.bot.service;

import org.springframework.stereotype.Service;
import telega.coffe.bot.command.Commands;
import telega.coffe.bot.command.CommandsContainer;
import telega.coffe.bot.service.api.FinderCommand;

@Service
public class FinderCommandImpl implements FinderCommand {

    private final CommandsContainer commandsContainer;

    public FinderCommandImpl(CommandsContainer commandsContainer) {
        this.commandsContainer = commandsContainer;
    }

    @Override
    public String getTextOnCommand(String searchCommand) {
        return commandsContainer.getCommand(Commands.get(searchCommand));
    }
}
