package telega.coffe.bot.coffebot;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import telega.coffe.bot.service.TelegramFacade;

@Getter
@Setter
@Slf4j
public class TestCoffeeZemaBot extends SpringWebhookBot {
    public static String COMMAND_PREFIX = "/";

    private final TelegramFacade telegramFacade;

    private String botPath;
    private String botUsername;
    private String botToken;

    public TestCoffeeZemaBot(TelegramFacade telegramFacade, DefaultBotOptions options, SetWebhook setWebhook) {
        super(options, setWebhook);
        this.telegramFacade = telegramFacade;
    }

    public TestCoffeeZemaBot(TelegramFacade telegramFacade, SetWebhook setWebhook) {
        super(setWebhook);
        this.telegramFacade = telegramFacade;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return telegramFacade.handleUpdate(update);
    }
}