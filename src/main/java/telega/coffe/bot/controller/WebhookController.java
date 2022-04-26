package telega.coffe.bot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import telega.coffe.bot.coffebot.TestCoffeeZemaBot;

@RestController
public class WebhookController {
    private final TestCoffeeZemaBot telegramBot;

    public WebhookController(TestCoffeeZemaBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
        return telegramBot.onWebhookUpdateReceived(update);
    }

    @GetMapping()
    public ResponseEntity get(){
        return ResponseEntity.ok().build();
    }
}