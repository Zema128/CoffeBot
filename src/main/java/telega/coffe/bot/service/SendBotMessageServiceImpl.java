package telega.coffe.bot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telega.coffe.bot.bots.TestCoffeeZemaBot;
import telega.coffe.bot.service.api.FinderCommand;
import telega.coffe.bot.service.api.SendBotMessageService;

import java.util.List;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final FinderCommand finderCommand;

    public SendBotMessageServiceImpl(FinderCommand finderCommand) {
        this.finderCommand = finderCommand;
    }

    @Override
    public SendMessage sendMessage(String chatId, String command) {
        String responseMessage = finderCommand.getTextOnCommand(command);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(responseMessage);
        sendMessage.enableMarkdown(true);
        return sendMessage;
    }

    @Override
    public SendMessage sendMessage(String chatId, List<String> commands) {
        return new SendMessage();
    }
}
