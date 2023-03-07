package telegram.bot.REBTBot.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import telegram.bot.REBTBot.controllers.MessageDispatcher;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramBot extends SpringWebhookBot {
    String botPath;
    String botUsername;
    String botToken;

    MessageDispatcher messageDispatcher;

    public TelegramBot(MessageDispatcher messageDispatcher,
                       DefaultBotOptions options,
                       SetWebhook setWebhook){
        super(options, setWebhook);
        this.messageDispatcher = messageDispatcher;
    }

    public TelegramBot(MessageDispatcher messageDispatcher, SetWebhook setWebhook) {
        super(setWebhook);
        this.messageDispatcher = messageDispatcher;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return messageDispatcher.handleUpdate(update);
    }
}
