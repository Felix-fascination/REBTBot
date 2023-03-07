package telegram.bot.REBTBot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import telegram.bot.REBTBot.controllers.MessageDispatcher;
import telegram.bot.REBTBot.models.TelegramBot;

@Configuration
public class AppConfig {
    private final TelegramConfig botConfig;

    public AppConfig(TelegramConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(botConfig.getWebhookPath()).build();
    }

    @Bean
    public TelegramBot springWebhookBot(SetWebhook setWebhook, MessageDispatcher messageDispatcher) {
        TelegramBot bot = new TelegramBot(messageDispatcher, setWebhook);
        bot.setBotToken(botConfig.getBotToken());
        bot.setBotUsername(botConfig.getBotName());
        bot.setBotPath(botConfig.getWebhookPath());

        return bot;
    }
}