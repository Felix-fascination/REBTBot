package telegram.bot.REBTBot.models.CallBackQueries;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.HashMap;

@Component
public class Callbackqueries {

    HashMap<String, Queryable> queries = new HashMap<>();

    public Callbackqueries(Level1 Level1, Level2 level2, Level3 level3,
                           Level4 level4, Level5 level5){
        queries.put("Level 1", Level1);
        queries.put("Level 2", level2);
        queries.put("Level 3", level3);
        queries.put("Level 4", level4);
        queries.put("Level 5", level5);
    }

    public Boolean containsQuery(String name){
        if(queries.containsKey(name)) return true;
        else return false;
    }

    public BotApiMethod<?> executeQuery(String name, CallbackQuery callbackQuery){
        Queryable queryable = queries.get(name);
        return queryable.execute(callbackQuery);
    }
}
