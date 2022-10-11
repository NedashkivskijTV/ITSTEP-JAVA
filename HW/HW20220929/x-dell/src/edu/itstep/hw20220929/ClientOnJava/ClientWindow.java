package edu.itstep.hw20220929.ClientOnJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWindow extends JFrame {
    // адреса сервера
    private static final String SERVER_HOST = "localhost";

    // порт
    private static final int SERVER_PORT = 3443;

    // сокет клієнта
    private Socket clientSocket;

    // вхідне повідомлення
    private Scanner inMessage;

    // вихідне повідомлення
    private PrintWriter outMessage;

    // поля - елементи форми
    private JTextField jtfMessage;
    private JTextField jtfName;
    private JTextArea jtaTextAreaMessage;

    // ім'я клієнта
    private String clientName = "";

    // геттер - отримання імені клієнта
    public String getClientName() {
        return clientName;
    }

    // конструктор
    public ClientWindow() {
        try {
            // підключення до сервера
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // налаштування елементів форми
        setBounds(600, 300, 600, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jtaTextAreaMessage = new JTextArea();
        jtaTextAreaMessage.setEditable(false);
        jtaTextAreaMessage.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jtaTextAreaMessage);
        add(jsp, BorderLayout.CENTER);

        // label, що відображатиме кількість клієнтів у чаті
        JLabel jlNumberOfClients = new JLabel("Кількість клієнтів у чаті: ");
        add(jlNumberOfClients, BorderLayout.NORTH);

        // кнопка відправлення
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Відправити");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);

        // текстові поля
        jtfMessage = new JTextField("Введіть ваше повідомлення: ");
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);
        jtfName = new JTextField("Введіть ваше ім'я: ");
        bottomPanel.add(jtfName, BorderLayout.WEST);

        // обробник події - натиснення кнопки відправки повідомлення
        jbSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // якщо поля ім'я клієнта та та повідомлення не пусті - відправляється повідомлення
                if (!jtfMessage.getText().trim().isEmpty() && !jtfName.getText().trim().isEmpty()) {
                    clientName = jtfName.getText();
                    sendMsg();
                    // фокус на текстове поле з повідомленням
                    jtfMessage.grabFocus();
                }
            }
        });

        // при фокусі поле повідомлення буде очищено
        jtfMessage.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfMessage.setText("");
            }
        });

        // при фокусі поле ім'я буде очищено
        jtfName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfName.setText("");
            }
        });

        // у окремому потоці починаємо роботу з сервером
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
                            String clientsInChat = "Учасників у счаті - ";
                            if (inMes.indexOf(clientsInChat) == 0) {
                                jlNumberOfClients.setText(inMes);
                            } else {
                                // виводимо повідомлення
                                jtaTextAreaMessage.append(inMes);
                                // додаємо рядок переходу
                                jtaTextAreaMessage.append("\n");
                            }
                        }
                    }
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }).start();

        // додаємо обробник події закриття вікна клієнтського застосунку
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    // перевірка чи ім'я клієнта непусте та не дорівнює значенню за замовчуванням
                    //if (!clientName.isEmpty() && clientName != "Введіть ваше ім'я: ") {
                    if (!clientName.isEmpty() && !clientName.equals("Введіть ваше ім'я: ")) {
                        outMessage.println(clientName + " вийшов з чату!");
                    } else {
                        outMessage.println("Участник вийшов з чату, не представившись!");
                    }

                    // відправка службового повідомлення, яке є ознакою того, що клієнт вийшов з чату
                    outMessage.println("##session##end##");
                    outMessage.flush();
                    outMessage.close();
                    inMessage.close();
                    clientSocket.close();
                } catch (IOException exc) {
                    //exc.printStackTrace();
                }
            }
        });

        // вдображення форми
        setVisible(true);
    }

    // відправлення повідомлення
    public void sendMsg() {
        // формування повідомлення для відправлення на сервер
        String messageStr = jtfName.getText() + ": " + jtfMessage.getText();

        // відправлення повідомлення
        outMessage.println(messageStr);
        outMessage.flush();
        jtfMessage.setText("");
    }
}
