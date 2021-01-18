package lesson07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;



public class GameMap extends JPanel {

    public static final int GAME_MODE_HVA = 0;
    public static final int GAME_MODE_HVH = 1;

    private static final int DOT_EMPTY = 0;
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;

    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private boolean isGameOver;
    private boolean initializedMap;

    private int stateGameOver;

    public static final Random RANDOM = new Random();

    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int[][] field;

    private int cellWidth;
    private int cellHeight;

    GameMap() {
        setBackground(Color.BLACK);
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                super.mouseReleased(e);
//                update(e);
//            }
//        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                update(e);
            }
        });
        initializedMap = false;
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        field = new int[fieldSizeX][fieldSizeY];
        isGameOver = false;
        initializedMap = true;
        repaint();
    }

    private void setGameOver(int gameOverState) {
        stateGameOver = gameOverState;
        isGameOver = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        render(g);
    }

    private void update(MouseEvent e) {
        if (!initializedMap) return;
        if (isGameOver) return;

        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) {
            return;
        }
        field[cellY][cellX] = DOT_HUMAN;

        if (checkWin(DOT_HUMAN)) {
            setGameOver(STATE_WIN_HUMAN);
            return;
        }

        if (isFullMap()) {
            setGameOver(STATE_DRAW);
            return;
        }

        aiTurn();
        repaint();
        if (checkWin(DOT_AI)){
            setGameOver(STATE_WIN_AI);
            return;
        }
        if (isFullMap()) {
            setGameOver(STATE_DRAW);
            return;
        }

    }

    private void render(Graphics g) {
        if (!initializedMap) return;

        int width = getWidth();
        int height = getHeight();

        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(Color.WHITE);

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {

                if (isEmptyCell(x,y)) {
                    continue;
                }

                if (field[y][x] == DOT_HUMAN) {
                    g.setColor(new Color(1,1,255));
                    g.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                } else if (field[y][x] == DOT_AI) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                } else {
                    throw new RuntimeException("Can't paint cellX " + x + " cellY " + y);
                }

            }
        }
        if (isGameOver) {
            showMessageGameOver(g);
        }
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 45));

        switch (stateGameOver) {
            case STATE_DRAW:
                g.drawString("ничья", 180, getHeight() / 2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString("победил пользователь!", 100, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString("Победил искуственный интеллект", 120, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpected game over state: " + stateGameOver);
        }
    }

    public void aiTurn() {
        if (turnAIWinCell()) {
            return;
        }
        if (turnHumanWinCell()) {
            return;
        }
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = DOT_AI;
                    if (checkWin(DOT_AI)) {
                        return true;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }


    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = DOT_HUMAN;
                    if (checkWin(DOT_HUMAN)) {
                        field[i][j] = DOT_AI;
                        return true;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private boolean checkWin(int c) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, c)) {
                    return true;
                }
                if (checkLine(i, j, 1, 1, winLength, c)) {
                    return true;
                }
                if (checkLine(i, j, 0, 1, winLength, c)) {
                    return true;
                }
                if (checkLine(i, j, 1, -1, winLength, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    // РїСЂРѕРІРµСЂРєР° Р»РёРЅРёРё
    private boolean checkLine(int x, int y, int vx, int vy, int len, int c) {
        final int farX = x + (len - 1) * vx;
        final int farY = y + (len - 1) * vy;
        if (!isValidCell(farX, farY)) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (field[y + i * vy][x + i * vx] != c) {
                return false;
            }
        }
        return true;
    }

    public boolean isFullMap() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    public boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }



}