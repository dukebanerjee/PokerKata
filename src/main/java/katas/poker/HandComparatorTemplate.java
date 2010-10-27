package katas.poker;

public abstract class HandComparatorTemplate implements HandComparator {
    protected abstract String nameOfHand();

    public abstract boolean blackIsApplicable();

    public abstract boolean whiteIsApplicable();

    protected abstract int compareHands();

    @Override
    public boolean isApplicable() {
        return whiteIsApplicable() || blackIsApplicable();
    }

    @Override
    public int compare() {
        if (whiteIsApplicable() && blackIsApplicable()) {
            return compareHands();
        } else if (whiteIsApplicable()) {
            return 1;
        } else if (blackIsApplicable()) {
            return -1;
        }
        throw new IllegalArgumentException("One of the hands must be " + nameOfHand());
    }
}
