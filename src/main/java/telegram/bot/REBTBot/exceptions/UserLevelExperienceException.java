package telegram.bot.REBTBot.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserLevelExperienceException extends RuntimeException{
    public UserLevelExperienceException(){
        log.warn("User level/experience exception");
    }
}
