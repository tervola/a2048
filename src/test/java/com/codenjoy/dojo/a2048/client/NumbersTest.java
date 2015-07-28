package com.codenjoy.dojo.a2048.client;

import com.codenjoy.dojo.client.Direction;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 7/28/2015.
 */
public class NumbersTest {
    private static int SIZE = 4;
    @Test
    public void simpleMove_caseNoMoveNeed(){
        //given
        String board =
                "++++" +
                "++++" +
                "++++" +
                "+2++";
        //when
        String action =  move(board, Direction.DOWN);

        //then
        assertEquals(
                "++++\n" +
                "++++\n" +
                "++++\n" +
                "+2++\n",
                action);
    }

    @Test
    public void simpleMove_caseMoveDown(){
        //given
        String board =
                "++++" +
                "++++" +
                "+2++" +
                "++++";
        //when
        String action =  move(board, Direction.DOWN);

        //then
        assertEquals(
                "++++\n" +
                "++++\n" +
                "++++\n" +
                "+2++\n",
                action);
    }

    private String move(String board, Direction direction) {
        //convert String bord  -> char[][]
        char[][] field =  convertFromString(board);
        //invoke game logic,

        field = moveLogic(field, direction);
        //convert back
        String updateBoard = convertFromField(field);
        return updateBoard;
    }

    private char[][] moveLogic(char[][] field, Direction direction) {
        int x =1; //TODO think about it
        for (int y = SIZE-1; y >0 ; y--) {
            if(field[x][y]=='2')
            {
                field[x][y] = '+';
                field[x][SIZE-1] = '2';
            }

        }

        return field;
    }

    private String convertFromField(char[][] field) {
        String rval = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char ch =  field[j][i];
                if(ch==' ')
                {
                    ch = '+';
                }

                rval += ch;
            }
            rval +="\n";
        }
        return rval;
    }

    private char[][] convertFromString(String board) {
        char[][] rval = new char[SIZE][SIZE];
        for (int i = 0; i < board.length(); i++) {
            int y = i / SIZE;
            int x = i % SIZE;
            char ch =  board.charAt(i);
            if(ch=='+')
            {
                rval[x][y] = ' ';
            }
            rval[x][y] = ch;
        }
        return rval;
    }

}
