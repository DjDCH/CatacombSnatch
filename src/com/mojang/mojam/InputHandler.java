package com.mojang.mojam;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import com.mojang.mojam.Keys.Key;

public class InputHandler implements KeyListener {
    private Map<Integer, Key> mappings = new HashMap<Integer, Key>();

    public InputHandler(Keys keys) {
        mappings.put(KeyEvent.VK_UP, keys.aim_up);
        mappings.put(KeyEvent.VK_DOWN, keys.aim_down);
        mappings.put(KeyEvent.VK_LEFT, keys.aim_left);
        mappings.put(KeyEvent.VK_RIGHT, keys.aim_right);

//        mappings.put(KeyEvent.VK_NUMPAD8, keys.move_up);
//        mappings.put(KeyEvent.VK_NUMPAD2, keys.move_down);
//        mappings.put(KeyEvent.VK_NUMPAD4, keys.move_left);
//        mappings.put(KeyEvent.VK_NUMPAD6, keys.move_right);

        mappings.put(KeyEvent.VK_W, keys.move_up);
        mappings.put(KeyEvent.VK_S, keys.move_down);
        mappings.put(KeyEvent.VK_A, keys.move_left);
        mappings.put(KeyEvent.VK_D, keys.move_right);

        mappings.put(KeyEvent.VK_SPACE, keys.fire);
        mappings.put(KeyEvent.VK_ALT, keys.fire);
        mappings.put(KeyEvent.VK_CONTROL, keys.fire);
        mappings.put(KeyEvent.VK_SHIFT, keys.fire);
        mappings.put(KeyEvent.VK_C, keys.fire);

        mappings.put(KeyEvent.VK_X, keys.build);
        mappings.put(KeyEvent.VK_Z, keys.use);
        mappings.put(KeyEvent.VK_R, keys.build);
        mappings.put(KeyEvent.VK_E, keys.use);

        /* DEBUG BEGIN */
        mappings.put(KeyEvent.VK_1, keys.give_money);
        mappings.put(KeyEvent.VK_2, keys.give_turret);
        mappings.put(KeyEvent.VK_3, keys.give_harvester);
        mappings.put(KeyEvent.VK_4, keys.give_bomb);
        mappings.put(KeyEvent.VK_5, keys.place_droid);
        mappings.put(KeyEvent.VK_6, keys.team1_score);
        mappings.put(KeyEvent.VK_7, keys.team2_score);
        mappings.put(KeyEvent.VK_8, keys.toggle_immortal);
        /* DEBUG END */
    }

    public void keyPressed(KeyEvent ke) {
        toggle(ke, true);
    }

    public void keyReleased(KeyEvent ke) {
        toggle(ke, false);
    }

    public void keyTyped(KeyEvent ke) {
    }

    private void toggle(KeyEvent ke, boolean state) {
        Key key = mappings.get(ke.getKeyCode());
        if (key != null) {
            key.nextState = state;
        }
    }
}
