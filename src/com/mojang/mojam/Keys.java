package com.mojang.mojam;

import java.util.*;

public class Keys {
    public final class Key {
        public boolean nextState = false;
        public boolean wasDown = false;
        public boolean isDown = false;

        public Key() {
            all.add(this);
        }

        public void tick() {
            wasDown = isDown;
            isDown = nextState;
        }

        public boolean wasPressed() {
            return !wasDown && isDown;
        }

        public boolean wasReleased() {
            return wasDown && !isDown;
        }

        public void release() {
            nextState = false;
        }
    }

    private List<Key> all = new ArrayList<Key>();

    public Key move_up = new Key();
    public Key move_down = new Key();
    public Key move_left = new Key();
    public Key move_right = new Key();

    public Key aim_up = new Key();
    public Key aim_down = new Key();
    public Key aim_left = new Key();
    public Key aim_right = new Key();

    public Key fire = new Key();
    public Key build = new Key();
    public Key use = new Key();

    /* DEBUG BEGIN */
    public Key give_money = new Key();
    public Key give_turret = new Key();
    public Key give_harvester = new Key();
    public Key give_bomb = new Key();
    public Key place_droid = new Key();
    public Key team1_score = new Key();
    public Key team2_score = new Key();
    public Key toggle_immortal = new Key();
    /* DEBUG END */

    public void tick() {
        for (Key key : all)
            key.tick();
    }

    public void release() {
        for (Key key : all)
            key.release();
    }

    public List<Key> getAll() {
        return all;
    }
}
