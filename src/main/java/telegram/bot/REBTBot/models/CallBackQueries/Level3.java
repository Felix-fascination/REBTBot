package telegram.bot.REBTBot.models.CallBackQueries;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
public class Level3 implements Queryable{
    @Override
    public BotApiMethod<?> execute(CallbackQuery query) {

        SendMessage sendMessage = new SendMessage(query.getFrom().getId().toString(), "little");
        return sendMessage;
    }
}
