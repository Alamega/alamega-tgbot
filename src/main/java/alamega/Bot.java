package alamega;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
        Message msg = update.getMessage();
        User user = msg.getFrom();

        switch (msg.getText()) {
            case "/start":
            case "Привет!":
                sendText(user.getId(), "Привет!");
                break;
            case "/help":
                sendText(user.getId(), "Нужна помощь?");
                break;
            default:
                sendText(user.getId(), "Чё говоришь?");
                break;
        }
    }

    public void sendText(Long userId, String text) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(userId.toString())
                .text(text).build();
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}