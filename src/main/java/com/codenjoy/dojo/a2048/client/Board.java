package com.codenjoy.dojo.a2048.client;

import com.codenjoy.dojo.a2048.model.Elements;
import com.codenjoy.dojo.client.AbstractBoard;
import com.codenjoy.dojo.client.Direction;

public class Board extends AbstractBoard<Elements> {

    @Override
    public Elements valueOf(char ch) {
        return Elements.valueOf(ch);
    }

    public char[][] getField() {
        return field;
    }

    // Add your methods here

}