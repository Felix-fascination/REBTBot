package telegram.bot.REBTBot.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegram.bot.REBTBot.controllers.handlers.CallbackQueryController;
import telegram.bot.REBTBot.controllers.handlers.MessageController;

@Component
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MessageDispatcher {

    MessageController messageController;
    CallbackQueryController callbackQueryController;

    public BotApiMethod<?> handleUpdate(Update update){
        if (update.hasCallbackQuery()) {
            return callbackQueryController.processCallbackQuery(update.getCallbackQuery());
        } else {
            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                return messageController.handleInputMessage(message);
            }
        }
        return null;
    }

}

