package telegram.bot.REBTBot.controllers.handlers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import telegram.bot.REBTBot.models.CallBackQueries.Callbackqueries;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CallbackQueryController {

    Callbackqueries queries;

    public BotApiMethod<?> processCallbackQuery(CallbackQuery buttonQuery){
        final String queryData = buttonQuery.getData();

        if (queries.containsQuery(queryData)){
            return queries.executeQuery(queryData, buttonQuery);
        }
        else {

            //Создать enum cо всеми состояниями, в которых может находиться пользователь, чтобы
            //При возможности проверить, как пример, его ответ кейсу и подобное
        }

        // Нужно сохранить в базу данных состояние пользователя - какую кнопку нажал и подобное


        return null;

    }
}
