package telega.coffe.bot.botconfig;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BotConfig {
    @Value("${telegrambot.userName}")
    String webHookPath;
    @Value("${telegrambot.botToken}")
    String userName;
    @Value("${telegrambot.webHookPath}")
    String botToken;
}
