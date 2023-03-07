package telegram.bot.REBTBot.models.messages;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Messageable {
    public BotApiMethod<?> execute(Message message);
}
