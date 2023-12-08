package alamega;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class Bot extends TelegramLongPollingBot {
    public Bot(String botToken) {
        super(botToken);
    }

    @Override
    public String getBotUsername() {
        return "AlamegaBot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        Message msg = update.getMessage();
        User user = msg.getFrom();
        System.out.println(user.getFirstName() + " wrote " + msg.getText());
    }
}