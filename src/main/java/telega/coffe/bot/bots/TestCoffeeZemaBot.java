package telega.coffe.bot.bots;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telega.coffe.bot.service.api.SendBotMessageService;

@Slf4j
@Component
public class TestCoffeeZemaBot extends TelegramLongPollingBot {
    private final SendBotMessageService sendService;

    public static String COMMAND_PREFIX = "/";

    private String userName = "test_coffe_zema_bot";

    private String token = "5350608805:AAFRDxUamfPv72NUTHRRNV-iX1hYmZoIHIU";

    public TestCoffeeZemaBot(SendBotMessageService sendService) {
        this.sendService = sendService;
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();
            if (message.startsWith(COMMAND_PREFIX)){
                String command = message.split(" ")[0].toLowerCase();
                try {
                    execute(sendService.sendMessage(chatId, command));
                } catch (TelegramApiException e) {
                    log.error("Ошибка при отправке ответа. Chat id = " + chatId + ". Ошибка: " + e.getMessage());
                }
            } else {
                sendDefaultMsg(chatId, "Чё то ты говно какое-то написал, давай ещё раз.");
            }
        }
    }

    public synchronized void sendDefaultMsg(String chatId, String msg){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(msg);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }
}
