package com.hussein;

import java.util.Objects;

/**
 * <p>Title: KeyObject</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/11 5:10 PM
 */
public class KeyObject {

    private int key;

    public KeyObject(int key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key % 4);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KeyObject keyObject = (KeyObject) o;
        return key == keyObject.key;
    }

    @Override
    public String toString() {
        return "KeyObject{" +
                "key=" + key +
                '}';
    }
}
