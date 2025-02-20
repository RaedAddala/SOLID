public class TimeSlot extends Slot{

    @Override
    public boolean isFree() {
        return _isFree;
    }

    @Override
    public void markSlotBusy() {
        // business logic before marking a slot busy
        this._isFree = false;
    }

    @Override
    public void markSlotFree() {
        // business logic before marking a slot free
        this._isFree = true;
    }
}
