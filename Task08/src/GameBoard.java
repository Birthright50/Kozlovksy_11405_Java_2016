import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Birthright on 04.12.2015.
 */
public class GameBoard {
    private JFrame main_frame;
    String[] options = {"OK"};
    private final String text_to_my_points;
    private final String text_to_enemy_points;
    private double my_points;
    private double enemy_points;
    public static final int SIZE = 19;
    private JPanel jPanel;
    private ObjectOutputStream ous;
    private ObjectInputStream ois;
    private JLabel black;
    private JLabel white;
    private int stones_count;
    public static final int NUMBER_OF_TILES = SIZE - 1;
    public static final int TILE_SIZE = 40;
    public static final int BORDER_SIZE = TILE_SIZE;
    private StoneColor my_color;
    private Grid grid;
    private JButton btnPass;
    private volatile boolean isYourTurn;
    private Message enemyMessage;

    private class TerritoryCount {
        JFrame jFrame = new JFrame() {
            {
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setBackground(new Color(204, 204, 204));
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                setForeground(Color.black);
            }
        };
        Box.Filler filler1;
        JButton go;
        JLabel first_text;
        JLabel jLabel2;
        JLabel error_count;
        JLabel jLabel4;
        JTextField jTextField1;
        JTextField jTextField2;
        int my_p;
        int enemy_p;
        int my_points_from_enemy;
        int enemy_points_from_enemy;
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE || (c == KeyEvent
                        .VK_DELETE)))) {
                    jFrame.getToolkit().beep();
                    e.consume();
                    ((JTextField)e.getSource()).setText(((JTextField)e.getSource()).getText().replaceAll("[^0-9]", ""));
                }
            }
        };

        public TerritoryCount(boolean first) {
            filler1 = new Box.Filler(new Dimension(250, 0), new Dimension(250, 0), new Dimension(250, 32767));
            first_text = new JLabel();
            error_count = new JLabel();
            jLabel2 = new JLabel();
            jLabel4 = new JLabel();
            go = new JButton();
            jTextField1 = new JTextField();
            jTextField1.addKeyListener(keyAdapter);
            jTextField2 = new JTextField();
            jTextField2.addKeyListener(keyAdapter);
            first_text.setHorizontalAlignment(SwingConstants.CENTER);
            error_count.setHorizontalAlignment(SwingConstants.CENTER);
            first_text.setText("Counting territories");
            error_count.setForeground(new Color(255, 0, 51));
            jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel2.setText("Your");
            jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel4.setText("Enemy");
            go.setText("GO");
            if (!first) {
                go.setEnabled(false);
                error_count.setText(
                        "The opponent considers the territory");
                jTextField1.setEnabled(false);
                jTextField2.setEnabled(false);
                new Thread(() -> {
                    waiting(false);
                }).start();
            }
            go.addActionListener(e -> {
                String my = jTextField1.getText();
                String enemy = jTextField2.getText();
                if (my.length() > 0 && enemy.length() > 0) {
                    my_p = Integer.parseInt(my);
                    enemy_p = Integer.parseInt(enemy);
                    if (!first) {
                        if (my_p == my_points_from_enemy && enemy_p == enemy_points_from_enemy) {
                            try {
                                ous.writeObject(new Message(true));
                                ous.flush();
                                if (my_p + my_points > enemy_p + enemy_points) {
                                    int code = JOptionPane.showOptionDialog(jFrame, "Congratulations!", "You won!", 0, JOptionPane.QUESTION_MESSAGE, null, options, "");
                                    if (code == 0) {
                                        jFrame.dispose();
                                        main_frame.dispose();
                                    }
                                } else {

                                    int code = JOptionPane.showOptionDialog(jFrame, "Game over!", "You lose!", 0, JOptionPane.QUESTION_MESSAGE, null, options, "");
                                    if (code == 0) {
                                        jFrame.dispose();
                                        main_frame.dispose();
                                    }
                                }
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            try {
                                ous.writeObject(new Message(false));
                                ous.flush();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            go.setEnabled(false);
                            error_count.setText(
                                    "You or your opponent incorrectly calculated the territory.");
                            jTextField1.setEnabled(false);
                            jTextField2.setEnabled(false);
                        }
                    } else {
                        go.setEnabled(false);
                        error_count.setText(
                                "The opponent considers the territory");
                        jTextField1.setEnabled(false);
                        jTextField2.setEnabled(false);
                        try {
                            ous.writeObject(new Message(my_p, enemy_p));
                            ous.flush();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        SwingUtilities.invokeLater(() -> waiting(true));
                    }

                }
            });

            GroupLayout layout = new GroupLayout(jFrame.getContentPane());
            jFrame.getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(69, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(error_count, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(64, 64, 64))
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                            .addComponent(jTextField2))
                                    .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(112, 112, 112)
                                                    .addComponent(first_text, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(178, 178, 178)
                                                    .addComponent(go)))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(first_text, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(error_count, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                    .addComponent(go)
                                    .addGap(32, 32, 32))
            );

            jFrame.pack();
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }

        private void waiting(boolean first) {
            try {
                Message message = (Message) ois.readObject();
                System.out.println(message.isEquals_counting());
                if (message.isEquals_counting()) {
                    if (my_p + my_points > enemy_p + enemy_points) {
                        int code = JOptionPane.showOptionDialog(jFrame, "Congratulations!", "You won!", 0, JOptionPane.QUESTION_MESSAGE, null, options, "");
                        if (code == 0) {
                            jFrame.dispose();
                            main_frame.dispose();
                        }
                    } else {
                        int code = JOptionPane.showOptionDialog(jFrame, "Game over!", "You lose!", 0, JOptionPane.QUESTION_MESSAGE, null, options, "");
                        if (code == 0) {
                            jFrame.dispose();
                            main_frame.dispose();
                        }
                    }
                } else {
                    if (!first) {
                        go.setEnabled(true);
                        jTextField1.setEnabled(true);
                        jTextField2.setEnabled(true);
                        my_points_from_enemy = message.getEnemy_territory();
                        enemy_points_from_enemy = message.getMy_territory();
                    } else {
                        go.setEnabled(true);
                        error_count.setText("You or your opponent incorrectly calculated the territory . Try again");
                        jTextField1.setEnabled(true);
                        jTextField2.setEnabled(true);
                    }

                }
            } catch (IOException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }

        }

    }


    public void writeStone(int col, int row, double my_points) {
        try {
            ous.writeObject(new Message(false, col, row, my_color, my_points, false));
            ous.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        drawReceivedStone();
    }

    public void drawReceivedStone() {
        try {
            enemyMessage = (Message) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (!enemyMessage.isPass()) {
            int[] points = grid.addStone(enemyMessage.getY(), enemyMessage.getX(), enemyMessage.getColor());
            my_points += points[1];
            enemy_points += points[0];
            if (enemyMessage.getColor() == StoneColor.BLACK) {
                black.setText(text_to_enemy_points + enemy_points);
                white.setText(text_to_my_points + my_points);
            } else {
                white.setText(text_to_enemy_points + enemy_points);
                black.setText(text_to_my_points + my_points);
            }
            jPanel.repaint();
            isYourTurn = true;
        } else {
            int selectedOption = JOptionPane.showConfirmDialog(null,
                    "Your opponent wants to end the game. Go to count territory ?",
                    "Simple question",
                    JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_OPTION) {
                try {
                    ous.writeObject(new Message(true, -1, -1, null, -1, true));
                    ous.flush();
                    btnPass.setBackground(Color.GREEN);
                    isYourTurn = false;
                    new TerritoryCount(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                if (selectedOption == JOptionPane.NO_OPTION) {
                    try {
                        ous.writeObject(new Message(true, -1, -1, null, -1, false));
                        isYourTurn = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }


    public GameBoard(StoneColor stoneColor, ObjectOutputStream ous, ObjectInputStream ois) {
        main_frame = new JFrame() {
            {
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        };
        this.ois = ois;
        this.ous = ous;
        JPanel container = new JPanel();
        container.setBackground(Color.ORANGE);
        container.setLayout(new BorderLayout(50, 50));
        btnPass = new JButton("Pass");
        btnPass.setBackground(Color.RED);
        btnPass.addActionListener(e -> {
            if (isYourTurn) {
                try {
                    ous.writeObject(new Message(true, -1, -1, null, -1, false));
                    btnPass.setBackground(Color.GREEN);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                isYourTurn = false;
                Thread thread = new Thread(() -> {
                    try {
                        Message message = (Message) ois.readObject();
                        if (message.isYesToPass()) {
                            new TerritoryCount(true);
                        } else {
                            btnPass.setBackground(Color.RED);
                            drawReceivedStone();
                        }
                    } catch (IOException | ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                });
                thread.start();
            }
        });
        container.add(btnPass, BorderLayout.PAGE_START);
        black = new JLabel();
        white = new JLabel();
        if (stoneColor == StoneColor.BLACK) {
            stones_count = 181;
            isYourTurn = true;
            text_to_my_points = "Black points (you) : ";
            text_to_enemy_points = "White points (enemy) : ";
            my_points = 0.0;
            enemy_points = 5.5;
            black.setText(text_to_my_points + my_points);
            white.setText(text_to_enemy_points + enemy_points);
        } else {
            Thread thread = new Thread(this::drawReceivedStone);
            thread.start();
            isYourTurn = false;
            stones_count = 180;
            text_to_my_points = "White points (you) : ";
            text_to_enemy_points = "Black points (enemy) : ";
            my_points = 5.5;
            enemy_points = 0.0;
            black.setText(text_to_enemy_points + enemy_points);
            white.setText(text_to_my_points + my_points);
        }
        container.add(black, BorderLayout.LINE_START);
        container.add(white, BorderLayout.LINE_END);
        main_frame.add(container);
        jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.BLACK);
                for (int i = 0; i < SIZE; i++) {
                    g2.drawLine(BORDER_SIZE, i * TILE_SIZE + BORDER_SIZE, TILE_SIZE
                            * NUMBER_OF_TILES + BORDER_SIZE, i * TILE_SIZE + BORDER_SIZE);
                }
                for (int i = 0; i < SIZE; i++) {
                    g2.drawLine(i * TILE_SIZE + BORDER_SIZE, BORDER_SIZE, i * TILE_SIZE
                            + BORDER_SIZE, TILE_SIZE * NUMBER_OF_TILES + BORDER_SIZE);
                }
                for (int row = 0; row < SIZE; row++) {
                    for (int col = 0; col < SIZE; col++) {
                        StoneColor state = grid.getState(row, col);
                        if (state != null) {
                            if (state == StoneColor.BLACK) {
                                g2.setColor(Color.BLACK);
                            } else {
                                g2.setColor(Color.WHITE);
                            }
                            g2.fillOval(col * TILE_SIZE + BORDER_SIZE - TILE_SIZE / 2,
                                    row * TILE_SIZE + BORDER_SIZE - TILE_SIZE / 2,
                                    TILE_SIZE, TILE_SIZE);
                        }
                    }
                }

            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(NUMBER_OF_TILES * TILE_SIZE + BORDER_SIZE * 2,
                        NUMBER_OF_TILES * TILE_SIZE + BORDER_SIZE * 2);
            }
        };
        container.add(jPanel);
        main_frame.pack();
        main_frame.setResizable(false);
        main_frame.setVisible(true);
        jPanel.setBackground(Color.ORANGE);
        grid = new Grid(SIZE);
        my_color = stoneColor;
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isYourTurn && stones_count > 0) {
                    int row = Math.round((float) (e.getY() - BORDER_SIZE)
                            / TILE_SIZE);
                    int col = Math.round((float) (e.getX() - BORDER_SIZE)
                            / TILE_SIZE);
                    System.out.println(String.format("row: %d, col: %d", row, col));

                    if (row >= SIZE || col >= SIZE || row < 0 || col < 0) {
                        return;
                    }
                    if (grid.isOccupied(row, col)) {
                        return;
                    }
                    int[] points = grid.addStone(row, col, my_color);

                    my_points += points[0];
                    enemy_points += points[1];
                    stones_count--;
                    jPanel.repaint();
                    isYourTurn = false;
                    if (my_color == StoneColor.BLACK) {
                        black.setText(text_to_my_points + my_points);
                        white.setText(text_to_enemy_points + enemy_points);
                    } else {
                        white.setText(text_to_my_points + my_points);
                        black.setText(text_to_enemy_points + enemy_points);
                    }
                    Thread thread = new Thread(() -> {
                        writeStone(col, row, my_points);
                    });
                    thread.start();
                }
            }
        });
    }


}
