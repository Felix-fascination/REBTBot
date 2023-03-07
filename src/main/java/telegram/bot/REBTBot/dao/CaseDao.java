package telegram.bot.REBTBot.dao;

import telegram.bot.REBTBot.models.Case;

import java.util.List;
import java.util.Optional;

public interface CaseDao{

    public Optional<List<Case>> getCasesByLevelAndUserId(int level, String id);

    public Optional<List<Case>> getUnknownCasesByLevelAndUserId (int level, String id);
}
