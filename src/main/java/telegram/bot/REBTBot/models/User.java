package telegram.bot.REBTBot.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import telegram.bot.REBTBot.exceptions.UserLevelExperienceException;

@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    final static int MAX_EXPERIENCE = 10000;
    final static int MAX_LEVEL = 5;
    @NonNull int id;
    @NonNull String username;
    int experience ;
    int level;

    public User(@NonNull int id, @NonNull String username, int experience, int level) {
        this.id = id;
        this.username = username;
        if (experience < 0 || experience > MAX_EXPERIENCE || level < 1 || level > MAX_LEVEL)
            throw new UserLevelExperienceException();
        else {
            this.experience = experience;
            this.level = level;
        }
    }

    public User(@NonNull int id, @NonNull String username) {
        this.id = id;
        this.username = username;
        this.level = 1;
        this.experience = 0;
    }

}
