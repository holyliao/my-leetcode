package com.liao.leetcode;

import java.io.Serializable;
import java.util.Map.Entry;
import java.util.Objects;

public abstract class Pair<L, R> implements Entry<L, R>, Serializable {
    private static final long serialVersionUID = 4954918890077093841L;

    public Pair() {
    }

    // 默认用的是子类ImmutablePair，
    public static <L, R> Pair<L, R> of(L left, R right) {
        return new ImmutablePair(left, right);
    }

    // 定义了抽象方法，目的子类去实现
    public abstract L getLeft();

    // 定义了抽象方法，目的子类去实现
    public abstract R getRight();

    // 这里的获取key其实就是获取getLeft()方法的值
    public final L getKey() {
        return this.getLeft();
    }

    // 这里的获取value  其实就是获取getRight()方法的值
    public R getValue() {
        return this.getRight();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry<?, ?> other = (Entry) obj;
            return Objects.equals(this.getKey(), other.getKey()) && Objects.equals(this.getValue(), other.getValue());
        }
    }

    public int hashCode() {
        return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue()
                                                                                                           .hashCode());
    }

    public String toString() {
        return "(" + this.getLeft() + ',' + this.getRight() + ')';
    }

    public String toString(String format) {
        return String.format(format, this.getLeft(), this.getRight());
    }
}
