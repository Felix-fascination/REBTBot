package telegram.bot.REBTBot.dao.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import telegram.bot.REBTBot.dao.UserDao;
import telegram.bot.REBTBot.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Slf4j
public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate;

    @Override
    public void insertUser(long id, String username) {
        if(findUserById(id).isEmpty()){
            String sql = "INSERT INTO \"user\" (user_id, username) VALUES(?, ?)";
            jdbcTemplate.update(sql, id, username);
            log.info("Added to DB this user: " + username + " - " + id);
        }
        else {
            log.debug("Trying to add the same user: " + username + " - " + id);
        }


    }

    @Override
    public Optional<User> findUserById(long id) {
        String sql = "select * from \"user\" where user_id = ?";

        List<User> user = jdbcTemplate.query(sql, (rs, rowNum) -> makeUser(rs), id);
        if(user.isEmpty()) return Optional.empty();
        else return Optional.of(user.get(0));
    }

    private User makeUser(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("user_id");
        String username = rs.getString("username");
        int experience = rs.getInt("user_experience");
        int level = rs.getInt("user_level");

        return new User(id, username, experience, level);
    }
}
