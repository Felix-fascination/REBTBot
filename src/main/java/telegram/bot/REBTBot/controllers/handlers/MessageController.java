package telegram.bot.REBTBot.controllers.handlers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import telegram.bot.REBTBot.models.messages.MessageCommands;
import telegram.bot.REBTBot.models.ReplyKeyboardMaker;

@Component
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MessageController {

    MessageCommands messageCommands;
    ReplyKeyboardMaker replyKeyboardMaker;

    public BotApiMethod<?> handleInputMessage(Message message){
        final String userId = message.getChatId().toString();
        String inputMessage = message.getText();

        if (messageCommands.containsCommand(inputMessage)){
            return messageCommands.executeCommand(inputMessage, message);
        }
        else {

            //Создать enum cо всеми состояниями, в которых может находиться пользователь, чтобы
            //При возможности проверить, как пример, его ответ кейсу и подобное
        }

        // Нужно сохранить в базу данных состояние пользователя - какую кнопку нажал и подобное


        return null;

    }
}
