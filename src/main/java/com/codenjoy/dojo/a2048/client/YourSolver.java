package com.codenjoy.dojo.a2048.client;

import com.codenjoy.dojo.client.Direction;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;

import java.util.Arrays;

/**
 * User: your name
 */
public class YourSolver implements Solver<Board> {

    private static final String USER_NAME = "stanislav.shumeyko@gmail.com";
    public static int COUNTER = 0;
    public static int count = 0;
    public static int result = 0;
    public static int LEFTCount = 0;

    @Override
    public String get(Board board) {
       String rval = Direction.UP.toString();
       char[][] field = board.getField();

        if(COUNTER==0) {
            COUNTER++;
            rval = Direction.ACT(0).toString();
        } else {
            COUNTER++;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if(Character.isDigit(field[i][j])) {
                        result += (int)field[i][j];
                    }
                    if(Character.isDigit(field[i][j]) && j != field[i].length -1 && field[i][j] == field[i][j+1])
                    {
                        count++;
                    }

                    if (count >=2) {
                        count = 0;
                        LEFTCount++;
                        if(LEFTCount >=4)
                        {
                            return Direction.UP.toString();
                        }
                        return Direction.LEFT.toString();
                    }

                }

            }
        }
        System.out.println("result = " + result);
        return rval;
    }


    public static void main(String[] args) {
        start(USER_NAME, WebSocketRunner.Host.REMOTE);
    }

    public static void start(String name, WebSocketRunner.Host server) {
        try {
            WebSocketRunner.run(server, name,
                    new YourSolver(),
                    new Board());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
