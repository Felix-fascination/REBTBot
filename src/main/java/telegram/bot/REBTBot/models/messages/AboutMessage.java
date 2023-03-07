package telegram.bot.REBTBot.models.messages;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class AboutMessage implements Messageable{
    @Override
    public BotApiMethod<?> execute(Message message) {

        return null;
    }
}
