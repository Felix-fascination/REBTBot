package telegram.bot.REBTBot.models.messages;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import telegram.bot.REBTBot.models.InlineReplyKeyboardMaker;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class LearningStart implements Messageable{

    InlineReplyKeyboardMaker inlineReplyKeyboardMaker;

    @Override
    public BotApiMethod<?> execute(Message message) {
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Дорогой гость, " +
                "выберите ваш уровень");
        sendMessage.setReplyMarkup(inlineReplyKeyboardMaker.getLearningStartMenu());
        return sendMessage;
    }
}
