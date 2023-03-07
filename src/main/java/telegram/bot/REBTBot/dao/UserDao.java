package telegram.bot.REBTBot.dao;

import telegram.bot.REBTBot.models.User;

import java.util.Optional;

public interface UserDao {

    void insertUser(long id, String username);

    Optional<User> findUserById(long id);
}
