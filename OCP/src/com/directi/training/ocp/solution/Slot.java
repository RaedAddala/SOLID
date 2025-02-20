public abstract class Slot {
    private boolean _isFree;
    public abstract boolean isFree();
    public abstract void markSlotBusy();
    public abstract void markSlotFree();
}
