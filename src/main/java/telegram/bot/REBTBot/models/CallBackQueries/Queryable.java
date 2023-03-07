package telegram.bot.REBTBot.models.CallBackQueries;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

interface Queryable {
    public BotApiMethod<?> execute(CallbackQuery callbackQuery);
}
