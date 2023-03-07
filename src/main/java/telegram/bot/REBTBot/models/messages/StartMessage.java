package telegram.bot.REBTBot.models.messages;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import telegram.bot.REBTBot.dao.UserDao;
import telegram.bot.REBTBot.models.ReplyKeyboardMaker;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StartMessage implements Messageable {
    UserDao userDao;

    @Override
    public BotApiMethod<?> execute(Message message) {
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Добро пожаловать, " +
                "" + message.getFrom().getFirstName());
        sendMessage.setReplyMarkup(ReplyKeyboardMaker.GetMainMenuKeyboard());
        userDao.insertUser(message.getChatId(), message.getFrom().getUserName());
        return sendMessage;
    }
}
