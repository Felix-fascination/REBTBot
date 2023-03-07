package telegram.bot.REBTBot.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Case {
    @NonNull Integer id;
    @NonNull Integer level;
    @NonNull String description;
    @NonNull String answers;
    @NonNull int rigth_answer;
}
