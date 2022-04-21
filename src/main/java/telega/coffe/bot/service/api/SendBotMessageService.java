package telega.coffe.bot.service.api;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

public interface SendBotMessageService {
    public SendMessage sendMessage(String chatId, String command);
    public SendMessage sendMessage(String chatId, List<String> commands);
}