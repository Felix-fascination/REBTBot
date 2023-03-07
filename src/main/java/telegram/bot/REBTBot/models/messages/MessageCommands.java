package telegram.bot.REBTBot.models.messages;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import telegram.bot.REBTBot.models.messages.AboutMessage;
import telegram.bot.REBTBot.models.messages.LearningStart;
import telegram.bot.REBTBot.models.messages.Messageable;
import telegram.bot.REBTBot.models.messages.StartMessage;

import java.util.HashMap;

@Component
public class MessageCommands {

    private final HashMap<String, Messageable> commands = new HashMap<>();

    public MessageCommands(StartMessage startMessage, AboutMessage aboutMessage,
                           LearningStart learningStart, MyScore myScore){
        commands.put("/start", startMessage);
        commands.put("ℹО боте и авторах", aboutMessage);
        commands.put("\uD83D\uDCAAПерейти к тренировке навыков", learningStart);
        commands.put("\uD83C\uDFC6Мой счет", myScore);

    }

    public Boolean containsCommand(String name){
        if(commands.containsKey(name)) return true;
        else return false;
    }

    public BotApiMethod<?> executeCommand(String name, Message message){
        Messageable messageable = commands.get(name);
        return messageable.execute(message);
    }


}
