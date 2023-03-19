package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main extends TelegramLongPollingBot {
    // Name - BanderogusGoitBot
    // UserName - BanderogusMarathonBot
    // API-token - 6152839454:AAFTjosbIOfjEHfXQn3IthsAIqHwF6VWl6Y

    // Властивість для збереження інф про рівень бандерогусака
    // зберігатиме пару - chatId-level - у кожного користувача може бути свій рівень і інф про них зберігатиметься окремо
    private Map<Long, Integer> levels = new HashMap<>();

    public static void main(String[] args) throws TelegramApiException {
        // для запуску бота необхідно створити допоміжний об'єкт TelegramBotsApi, передавши до параметрів об'єкт сесії (DefaultBotSession.class)
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new Main());

        //System.out.println("Hello world!");
    }

    @Override
    public String getBotUsername() {
        return "BanderogusMarathonBot"; // повертає назву бота
    }

    @Override
    public String getBotToken() {
        return "6152839454:AAFTjosbIOfjEHfXQn3IthsAIqHwF6VWl6Y"; // повертає токен
    }

    @Override
    public void onUpdateReceived(Update update) {
        // корисна робота - створення повідомлень
        Long chatId = getChatId(update); // отримання ID чату у окремому методі

/* закоментовано для реалізації макету бота для 2 заніття

//        Код винесено у окремий метод
//        SendMessage message = new SendMessage(); // сворення об'єкта повідомлення/message
//        message.setText("Hello World!!!"); // ініціалізація об'єкта message
//        message.setChatId(chatId); // встановлення id чата (з параметра update) - для відокремлення діалогових ланцюжків
//        sendApiMethodAsync(message); // асинхронна відправка повідомлення у чат

        // відправка форматованого тексту - слово виділяється * - спеціальний markdown-формат
        SendMessage msg = createMassage("*Hello* Taras !!!");

        // Додавання до повіддомлення кнопок
        // Застосовується статичний метод Map.of(), який дозволяє створити структуру даних Map
        attachButtons(msg, Map.of(
                "BTN 1", "hello_btn_1",
                "BTN 2", "hello_btn_2"
        ));

        msg.setChatId(chatId);
        sendApiMethodAsync(msg);
*/

//         Закометтовано для реалізації сценарію роботи бота на 3-му занятті
//        /** Обробники отриманих повідомлень та натискання кнопок */
//        // Перевірка отримання повідомлення START від користувача та формування повідомлення (з кнопкою) у відповідь
//        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
//            SendMessage message = createMassage("Привіт!");
//            message.setChatId(chatId);
//            attachButtons(message, Map.of(
//                    "Слава УКРАЇНІ!", "glory_for_ukraine"
//            ));
//            sendApiMethodAsync(message); // відправлення повідомлення
//        }
//
//        // Обробник натискання на будь-яку кнопку
//        if (update.hasCallbackQuery()) { // перевірка чи була натиснути будь яка кнопка
//            // Обробник по натисканню на кнопку "Слава Україні!"
//            if (update.getCallbackQuery().getData().equals("glory_for_ukraine")) {
//                SendMessage message = createMassage("Героям Слава!");
//                message.setChatId(chatId);
//                attachButtons(message, Map.of(
//                        "Слава НАЦІЇ!", "glory_for_nation"
//                ));
//                sendApiMethodAsync(message); // відправлення повідомлення
//            }
//
//            // Обробник по натисканню на кнопку "Слава НАЦІЇ!"
//            if (update.getCallbackQuery().getData().equals("glory_for_nation")) {
//                SendMessage message = createMassage("СМЕРТЬ ВОРОГАМ !!!!");
//                message.setChatId(chatId);
//                sendApiMethodAsync(message); // відправлення повідомлення
//            }
//        }

        /** Обробники отриманих повідомлень та натискання кнопок
         * - відображення текстових повідомлень
         * - кнопок
         * - зображень*/
        // Перевірка отримання повідомлення /start від користувача та формування повідомлення у відповідь
        // - із зображенням, текстовим блоком та набором кнопок
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {

            // встановлення первинного значення level = 1
            setLevel(chatId, 1);

            // Send image level 1
            sendImage("level-1", chatId);

            // Send message
            SendMessage message = createMassage("Ґа-ґа-ґа!\n" +
                    "Вітаємо у боті біолабораторії «Батько наш Бандера».\n" +
                    "\n" +
                    "Ти отримуєш гусака №71\n" +
                    "\n" +
                    "Цей бот ми створили для того, щоб твій гусак прокачався з рівня звичайної свійської худоби до рівня біологічної зброї, здатної нищити ворога. \n" +
                    "\n" +
                    "Щоб звичайний гусак перетворився на бандерогусака, тобі необхідно:\n" +
                    "✔️виконувати завдання\n" +
                    "✔️переходити на наступні рівні\n" +
                    "✔️заробити достатню кількість монет, щоб придбати Джавеліну і зробити свєрхтра-та-та.\n" +
                    "\n" +
                    "*Гусак звичайний.* Стартовий рівень.\n" +
                    "Бонус: 5 монет.\n" +
                    "Обери завдання, щоб перейти на наступний рівень");
            message.setChatId(chatId);

            // Колекція кнопок з яких потрібно обрати та відобразити 3
            List<String> buttons = Arrays.asList(
                    "Сплести маскувальну сітку (+15 монет)",
                    "Зібрати кошти патріотичними піснями (+15 монет)",
                    "Вступити в Міністерство Мемів України (+15 монет)",
                    "Запустити волонтерську акцію (+15 монет)",
                    "Вступити до лав тероборони (+15 монет)"
            );

            // отримання 3 кнопок з загальної колекції
            buttons = getRandom3(buttons);

            // Create buttons
            attachButtons(message, Map.of(
                    //"Сплести маскувальну сітку (+15 монет)", "level_1_task",
                    //"Зібрати кошти патріотичними піснями (+15 монет)", "level_1_task",
                    //"Вступити в Міністерство Мемів України (+15 монет)", "level_1_task"
                    buttons.get(0), "level_1_task",
                    buttons.get(1), "level_1_task",
                    buttons.get(2), "level_1_task"
            ));
            sendApiMethodAsync(message); // відправка повідомлення
        }

        // Обробник натискання на будь-яку кнопку
        if (update.hasCallbackQuery()) { // перевірка чи була натиснути будь-яка кнопка

            // Обробник по натисканню на кнопку з id level_1_task
            //if (update.getCallbackQuery().getData().equals("level_1_task")) {
            if (update.getCallbackQuery().getData().equals("level_1_task") && getLevel(chatId) == 1) { // перевірка номера рівня - має бути 1
                // increase level
                // встановлення level = 2
                setLevel(chatId, 2);

                // Send image level 2
                sendImage("level-2", chatId);

                // Send message
                SendMessage message = createMassage("*Вітаємо на другому рівні! Твій гусак - біогусак.*\n" +
                        "Баланс: 20 монет. \n" +
                        "Обери завдання, щоб перейти на наступний рівень\n");
                message.setChatId(chatId);

                // Колекція кнопок з яких потрібно обрати та відобразити 3
                List<String> buttons = Arrays.asList(
                        "Зібрати комарів для нової біологічної зброї (+15 монет)",
                        "Пройти курс молодого бійця (+15 монет)",
                        "Задонатити на ЗСУ (+15 монет)",
                        "Збити дрона банкою огірків (+15 монет)",
                        "Зробити запаси коктейлів Молотова (+15 монет)"
                );

                // отримання 3 кнопок з загальної колекції
                buttons = getRandom3(buttons);

                // Create buttons
                attachButtons(message, Map.of(
                        buttons.get(0), "level_2_task",
                        buttons.get(1), "level_2_task",
                        buttons.get(2), "level_2_task"
                ));
                sendApiMethodAsync(message); // відправка повідомлення
            } else if (update.getCallbackQuery().getData().equals("level_2_task") && getLevel(chatId) == 2) {
                // increase level
                // встановлення level = 3
                setLevel(chatId, 3);

                // Send image level 3
                sendImage("level-3", chatId);

                // Send message
                SendMessage message = createMassage("*Вітаємо на третьому рівні! Твій гусак - бандеростажер.*\n" +
                        "Баланс: 35 монет. \n" +
                        "Обери завдання, щоб перейти на наступний рівень");
                message.setChatId(chatId);

                // Колекція кнопок з яких потрібно обрати та відобразити 3
                List<String> buttons = Arrays.asList(
                        "Злітати на тестовий рейд по чотирьох позиціях (+15 монет)",
                        "Відвезти гуманітарку на передок (+15 монет)",
                        "Знайти зрадника та здати в СБУ (+15 монет)",
                        "Навести арту на орків (+15 монет)",
                        "Притягнути танк трактором (+15 монет)"
                );

                // отримання 3 кнопок з загальної колекції
                buttons = getRandom3(buttons);

                // Create buttons
                attachButtons(message, Map.of(
                        buttons.get(0), "level_3_task",
                        buttons.get(1), "level_3_task",
                        buttons.get(2), "level_3_task"
                ));
                sendApiMethodAsync(message); // відправка повідомлення
            } else if (update.getCallbackQuery().getData().equals("level_3_task") && getLevel(chatId) == 3) {
                // increase level
                // встановлення level = 4
                setLevel(chatId, 4);

                // Send image level 4
                sendImage("level-4", chatId);

                // Send message
                SendMessage message = createMassage("*Вітаємо на останньому рівні! Твій гусак - готова біологічна зброя - бандерогусак.*\n" +
                        "Баланс: 50 монет. \n" +
                        "Тепер ти можеш придбати Джавелін і глушити чмонь");
                message.setChatId(chatId);

                // Create buttons
                attachButtons(message, Map.of(
                        "Купити Джавелін (50 монет)", "level_4_task"
                ));
                sendApiMethodAsync(message); // відправка повідомлення
            } else if (update.getCallbackQuery().getData().equals("level_4_task") && getLevel(chatId) == 4) {
                // increase level
                // встановлення level = 5
                setLevel(chatId, 5);

                // Send message without image
                SendMessage textMessage = createMassage("*Джавелін твій. Повний вперед!*");
                textMessage.setChatId(chatId);
                sendApiMethodAsync(textMessage); // відправка повідомлення

                // Send final image
                sendImage("final", chatId);
            }
        }
    }

    /**
     * Отримання ID чату
     *
     * @param update
     * @return
     */
    public Long getChatId(Update update) {
        if (update.hasMessage()) { // у разі отримання текстових повідомлень
            //return update.getMessage().getChatId();
            return update.getMessage().getFrom().getId();
        }

        if (update.hasCallbackQuery()) { // у разі натискання на конопки
            return update.getCallbackQuery().getFrom().getId();
        }

        return null;
    }

    /**
     * Створення повідомлення
     *
     * @param text
     * @return
     */
    public SendMessage createMassage(String text) {
        SendMessage message = new SendMessage(); // об'єкт повідомлення в термінології

        //message.setText(text); // При використанні кирилиці у боті відображатиметься нечитабельний текст через різне кодування,
        /** оскільки телеграм використовує UTF8, а Java UTF16 потрібно привести текст до кодування UTF8 */
        message.setText(new String(text.getBytes(), StandardCharsets.UTF_8)); // створення повідомлення у потрібному кодуванні
        // - взято текст у кодуванні Java (UTF16) та переведено в кодування UTF8

        message.setParseMode("markdown"); // для відправки форматованих повідомлень (видділення жирним ...)
        return message;
    }

    /**
     * Відображення кнопок у відповідь на отримане повідомлення
     *
     * @param message - повідомлення
     * @param buttons - спеціальний об'єкт - колекція Map
     *                колекція зберігає кнопки які мають видиму частину (перший рядок) та
     *                ідентифікатор (payload - у термінах Telegram) (ідентифікатор кнопки - характеризує кнопку, до 64 символів, 2-й рядок)
     *                - приклад -> BUTTON => btn (зроблено для відображення назхви кнопки згідно обраної мови, при тому, що ідентифікатор у коді використовуватиметься один)
     */
    public void attachButtons(SendMessage message, Map<String, String> buttons) {
        // Створення зовнішнього об'єкту який генерує всю розмітку клавіатури
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        // Оскільки клавіатура - двовимірний об'єкт, створюється список списків для зберігання кнопок
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        // Цикл, що пробігає по колекції ключів (це відображувані назви кнопок)
        for (String buttonName : buttons.keySet()) {
            String buttonValue = buttons.get(buttonName); // отримання значення кожної кнопки

            // створення нової кнопки
            InlineKeyboardButton button = new InlineKeyboardButton();
            //button.setText(buttonName); // встановлення новоствореній кнопці видимої частини (ключ) - при використанні кирилиці потрібно перевести у кодування UTF8
            button.setText(new String(buttonName.getBytes(), StandardCharsets.UTF_8)); // встановлення новоствореній кнопці видимої частини (ключ) з переведенням кодування з UTF16 у UTF8
            button.setCallbackData(buttonValue); // встановлення новоствореній кнопці ідентифікатора

            keyboard.add(Arrays.asList(button)); // Додавання створеної кнопки до колекції кнопок
        }

        // прикріплення клавіатури до повідомлення
        markup.setKeyboard(keyboard);
        message.setReplyMarkup(markup);
    }

    /**
     * Відправка зображень
     *
     * @param name   - назва файлу зображення
     * @param chatId - унікальний ідентифікатор чату
     */
    public void sendImage(String name, Long chatId) {
        // Об'єкт анімації
        SendAnimation animation = new SendAnimation();

        // Об'єкт для отримання анімації з файлу
        InputFile inputFile = new InputFile();
        inputFile.setMedia(new File("images/" + name + ".gif")); // формування імені файлу зображення

        animation.setAnimation(inputFile);
        animation.setChatId(chatId);

        executeAsync(animation); // Відправка зображення
    }

    /**
     * Допоміжний метод - отримання level - рівня бандерогусака
     *
     * @param chatId
     * @return
     */
    public int getLevel(Long chatId) {
        return levels.getOrDefault(chatId, 1); // Вважаємо, що якщо явним чином level не встановлений, то повертається 1
    }

    /**
     * Допоміжний метод -встановлення рівня бандерогусака
     *
     * @param chatId
     * @param level
     */
    public void setLevel(Long chatId, int level) {
        levels.put(chatId, level);
    }

    /**
     * Вибір 3 кнопок із запропонованої колекції
     *
     * @param variants - колекція кнопок (>= 3)
     * @return - колекція з 3 рандомно відібраних кнопок із загальної кількості запропонованих
     */
    public List<String> getRandom3(List<String> variants) {
        ArrayList<String> copy = new ArrayList<>(variants); // створення копії колекції кнопок
        Collections.shuffle(copy); // перемішування кнопок у колекції
        return copy.subList(0, 3); // повернення підколекції, що включає перші 3 елементи з отриманої у параметрах та перемішаної колекції кнопок
    }
}
