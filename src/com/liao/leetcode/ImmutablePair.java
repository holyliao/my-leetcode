package com.liao.leetcode;

// 继承了Pair
public final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final ImmutablePair NULL = of((Object) null, (Object) null);
    private static final long serialVersionUID = 4954918890077093841L;
    // 这里用了final修饰，代表的left值设值之后是不可变
    public final L left;
    // 这里用了final修饰，代表的right值设值之后是不可变
    public final R right;

    public static <L, R> ImmutablePair<L, R> nullPair() {
        return NULL;
    }

    public static <L, R> ImmutablePair<L, R> of(L left, R right) {
        return new ImmutablePair(left, right);
    }

    public ImmutablePair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    // 因为是不可变的值，所以如果set值的话直接抛异常
    public R setValue(R value) {
        throw new UnsupportedOperationException();
    }
}