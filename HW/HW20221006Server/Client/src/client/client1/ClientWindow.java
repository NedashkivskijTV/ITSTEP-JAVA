package client.client1;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClientWindow extends JFrame {
    private static final String SERVER_HOST = "localhost"; // адреса сервера

    private static final int SERVER_PORT = 3443; // порт

    private Socket clientSocket; // сокет клієнта

    private Scanner inMessage; // вхідне повідомлення

    private PrintWriter outMessage; // вихідне повідомлення

    List<Place> places = new ArrayList<>(); // колекція зайнятих місць, отримана від сервера
    List<Place> placesSelectedByClient = new ArrayList<>(); // колекція зайнятих місць, отримана від сервера

    // поля - елементи форми
//    private JTextField jtfMessage;
//    private JTextField jtfName;
//    private JTextArea jtaTextAreaMessage;
//    private JLabel jlNumberOfClients;
//    private JLabel jlNamesOfClients;
    List<JButton> buttonList = new ArrayList<>(); // колекція кнопок - місць
    JButton jButtonOk; // кнопка передачі данних
    JTextField jTextField; // текстове поле
    String tempString = ""; // тимчасове збереження вмісту текстового поля при отриманні/втраті фокуса


    // ім'я клієнта
    //private String clientName = "";

    // прапорець відправлення імені клієнта на сервер
    //private boolean isNameSending = false;

    // геттер - отримання імені клієнта
    //public String getClientName() {
    //    return clientName;
   // }

    // конструктор
    public ClientWindow() {
        // підключення до сервера
        serverConnection();

        // налаштування елементів форми
        formSettings();
        addListeners();

        // у окремому потоці відбувається робота з сервером
        serverThread();
    }

    // підключення до сервера
    public void serverConnection() {
        try {
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void formSettings() {
        // налаштування елементів форми
        JPanel jPanel = new JPanel(new BorderLayout(5, 5)); // основна панель

        JPanel jPanelForButtons = new JPanel(new GridLayout(3, 3)); // другорядна панель - панель для кнопок - місць
        JPanel jPanelForTextFieldAndSubmitButton = new JPanel(new GridLayout(1, 2)); // другорядна панель - панель для текстового поля та кнопки ОК

        // генерування кнопок-мість та їх додавання до масиву кнопок
        for (int i = 0; i < 9; i++) {
            buttonList.add(new JButton("" + (i + 1)));
        }

        // додавання кнопок-місць з масиву кнопок до панелі кнопок
        for (JButton jButton : buttonList) {
            jButton.setBackground(ColorRGB.GREY.getColor()); // встановлення дефолтного кольору

            // додавання до панелі
            jPanelForButtons.add(jButton);
        }

        // ініціалізація текстового поля та кнопки ОК, а також їх приєднання до панелі
        jButtonOk = new JButton("OK");
        //jButtonOk.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        jTextField = new JTextField("Enter phone number");
        jPanelForTextFieldAndSubmitButton.add(jTextField);
        jPanelForTextFieldAndSubmitButton.add(jButtonOk);

        // приєднання другорядних панелей до основної
        jPanel.add(jPanelForButtons, BorderLayout.CENTER);
        jPanel.add(jPanelForTextFieldAndSubmitButton, BorderLayout.SOUTH);

        // отримання даних з БД
        //downloadDB();

        // приєднання основної панелі до вікна, візуалізація
        add(jPanel);
        setVisible(true);
    }

    // подія -- натискання кнопки місця - зміна кольору сірий-жовтий-сірий
    public void addListeners() {
        for (JButton jButton : buttonList) {
            jButton.addActionListener(e -> {
                if (!Objects.equals(jButton.getBackground(), ColorRGB.RED.getColor()) &&
                        !Objects.equals(jButton.getBackground(), ColorRGB.GREEN.getColor())) {
                    if (Objects.equals(jButton.getBackground(), ColorRGB.YELLOW.getColor())) {
                        jButton.setBackground(ColorRGB.GREY.getColor());
                    } else {
                        jButton.setBackground(ColorRGB.YELLOW.getColor());
                    }
                    //System.out.println(jButton.getBackground().toString());
                }
            });
        }

        // подія - натискання кнопки ОК
        jButtonOk.addActionListener(e -> {
            if (checkTextField()) {
                List<JButton> buttonsPressed = buttonList
                        .stream()
                        .filter(b -> Objects.equals(b.getBackground(), ColorRGB.YELLOW.getColor()))
                        .collect(Collectors.toList());
                for (JButton jButton : buttonsPressed) {
                    Place p = new Place(jButton.getText(), jTextField.getText());
                    //Db.insertPlace(p1);
                    placesSelectedByClient.add(p); // додавання обраних місць до колекції
                    jButton.setBackground(ColorRGB.GREEN.getColor());
                }
                //------------------------------------------------------------------------------------------------------
                // серіалізація
                // відправлення на сервер
                //------------------------------------------------------------------------------------------------------
                jTextField.setText("Enter phone number");
            }
        });

        // подія - якщо текстове поле знаходиться у фокусі -
        // текст очищується/залишається введений рніше рядок,
        // що зберігається у змінній екземпляра tempString
        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //super.focusGained(e);
                jTextField.setText(tempString);
            }
        });

        // подія - втрата фокуса на текстовому полі -
        // збереження тексту, що до цього введений у текстовому полі
        // до змінної екземпляра tempString
        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                //super.focusLost(e);
                tempString = jTextField.getText();
            }
        });
    }

    // перевірка коректності тексту у текстовому полі
    public boolean checkTextField() {
        String text = jTextField.getText();
        if (text.equals("Enter phone number")) {
            return false;
        } else return !text.isEmpty();
    }

    public void serverThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // нескінченний цикл
                    while (true) {
                        // якщо є вхідне повідомлення
                        if (inMessage.hasNext()) {
                            // читаємо нове повідомлення
                            String inMes = inMessage.nextLine();
                            String clientsInChat = "Учасників у чаті - ";
                            String clientsNames = "Список учасників чату :";
                            if (inMes.indexOf(clientsInChat) == 0) {
                                //jlNumberOfClients.setText(inMes);
                            } else if (inMes.contains(clientsNames)) {
                                // при отриманні повідомлення, що містить список імен клієнтів
                                //System.out.println("список отримано");
                                //System.out.println(inMes);
                                //jlNamesOfClients.setText(inMes);
                            } else {
                                // виводимо повідомлення
                                //jtaTextAreaMessage.append(inMes);
                                // додаємо рядок переходу
                                //jtaTextAreaMessage.append("\n");
                                //--------------------------------------------------------------------------------------
                                // десеріалізувати повідомлення
                                Gson gson = new Gson();
                                //List<Place> list = new ArrayList<>();
                                //List<Place> placesForClient = gson.fromJson(inMes, list.getClass());
                                places = gson.fromJson(inMes, places.getClass());

                                // тестове повідомлення в консоль клієнта - отримана від сервера колекція
                                System.out.println("Отримана колекція - ");
                                places.forEach(System.out::println);

                                // оновити вигляд клієнтського вікна
                                loudOllPlaces(places);
                                //--------------------------------------------------------------------------------------
                            }
                        }
                    }
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }).start();
    }

    // метод, що містить алгоритм попередніх переврок
    // та команду на відправку повідомлення
    public void messageSendingWithConditions() {
        // якщо поля ім'я клієнта та повідомлення не пусті - відправляється повідомлення
        if (!jtfMessage.getText().trim().isEmpty() && !jtfName.getText().trim().isEmpty()) {
            clientName = jtfName.getText();
            sendMsg();
            // фокус на текстове поле з повідомленням
            jtfMessage.grabFocus();
        }
    }

    // відправлення повідомлення
    public void sendMsg() {
        // формування повідомлення для відправлення на сервер
        String messageStr = jtfName.getText() + ": " + jtfMessage.getText();

        // відправлення на сервер імені клієнта
//        if (!isNameSending) {
//            outMessage.println("##client##name##" + clientName);
//            outMessage.flush();
//            jtfName.setEditable(false); // після відправки імені користувача на сервер поле стає незмінним
//            isNameSending = true;
//        }

        // відправлення повідомлення
        outMessage.println(messageStr);
        outMessage.flush();
        //jtfMessage.setText("");
    }

    public void loudOllPlaces(List<Place> places){
        for (JButton jButton : buttonList) {
            for (Place place : places) {
                if (jButton.getText().equals(place.getNum())) {
                    jButton.setBackground(ColorRGB.RED.getColor());
                }
            }
        }
    }

}
