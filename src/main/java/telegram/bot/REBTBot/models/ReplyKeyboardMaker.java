package telegram.bot.REBTBot.models;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReplyKeyboardMaker {

    public static ReplyKeyboardMarkup GetMainMenuKeyboard(){
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("\uD83D\uDCDDОбучение. Что нужно знать, чтобы начать тренироваться"));
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("\uD83D\uDCAAПерейти к тренировке навыков"));
        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("\uD83C\uDFC6Мой счет"));
        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("ℹО боте и авторах"));

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboard);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setResizeKeyboard(false);
        replyKeyboardMarkup.setSelective(false);

        return replyKeyboardMarkup;
    }

}
