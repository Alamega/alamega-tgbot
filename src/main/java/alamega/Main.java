package alamega;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot(BotProperties.getProperty("TOKEN"));
        botsApi.registerBot(bot);
        System.out.println("Я запустился");
        bot.sendText(Long.parseLong(BotProperties.getProperty("OWNER")), "Я запустился");
    }
}