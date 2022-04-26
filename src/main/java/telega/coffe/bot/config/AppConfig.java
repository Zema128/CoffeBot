package telega.coffe.bot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

import telega.coffe.bot.botconfig.BotConfig;
import telega.coffe.bot.coffebot.TestCoffeeZemaBot;
import telega.coffe.bot.service.TelegramFacade;

@Configuration
public class AppConfig {
    private final BotConfig botConfig;

    public AppConfig(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Bean
    public SetWebhook setWebhookInstance(){
        return SetWebhook.builder().url(botConfig.getWebHookPath()).build();
    }

    @Bean
    public TestCoffeeZemaBot setWebHookBot(SetWebhook setWebhook, TelegramFacade telegramFacade){
        TestCoffeeZemaBot bot = new TestCoffeeZemaBot(telegramFacade, setWebhook);
        bot.setBotToken(botConfig.getBotToken());
        bot.setBotUsername(botConfig.getUserName());
        bot.setBotPath(botConfig.getWebHookPath());
        return bot;
    }
}
