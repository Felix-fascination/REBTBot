package telegram.bot.REBTBot.dao.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import telegram.bot.REBTBot.dao.CaseDao;
import telegram.bot.REBTBot.models.Case;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CaseDaoImpl implements CaseDao {
    JdbcTemplate jdbcTemplate;

    @Override
    public Optional<List<Case>> getCasesByLevelAndUserId(int level, String id) {

        String sql = "SELECT * FROM user as u " +
                "INNER JOIN users_cases as us on u.user_id = us.user_id " +
                "INNER JOIN case as c on us.case_id = c.case_id " +
                "HAVING c.case_level = ? AND u.user_id = ?";

        List<Case> cases = jdbcTemplate.query(sql, ((rs, rowNum) -> makeCase(rs)), level, id);
        if (cases.isEmpty()) return Optional.empty();
        else return Optional.of(cases);
    }

    @Override
    public Optional<List<Case>> getUnknownCasesByLevelAndUserId(int level, String id) {
        return Optional.empty();
    }

    private Case makeCase(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("case_id");
        int level = rs.getInt("case_level");
        String description = rs.getString("description");
        String answers = rs.getString("answers");
        int right_answer = rs.getInt("right_answer");

        return new Case(id, level, description, answers, right_answer);
    }
}
