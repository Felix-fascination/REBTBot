package telegram.bot.REBTBot.models;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class InlineReplyKeyboardMaker {

    private List<InlineKeyboardButton> getInlineButton (String name, String buttonCallbackData){
        InlineKeyboardButton button = new InlineKeyboardButton(name);
        button.setCallbackData(buttonCallbackData);

        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(button);
        return row;
    }

    public InlineKeyboardMarkup getLearningStartMenu(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        rowList.add(getInlineButton("1 уровень", "Level 1"));
        rowList.add(getInlineButton("2 уровень", "Level 2"));
        rowList.add(getInlineButton("3 уровень", "Level 3"));
        rowList.add(getInlineButton("4 уровень", "Level 4"));
        rowList.add(getInlineButton("5 уровень", "Level 5"));

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

}
