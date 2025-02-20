package com.directi.training.ocp.exercise;

public class ResourceAllocator
{
    private List<Slot> _slots;

    public Slot allocate(){
        Slot slot = this.findFreeSlot();
        if (slot != null) {
            slot.markSlotBusy();
        }
        return slot;
    }

    public void free(Slot slot){
        slot.markSlotFree();
    }

    public Slot findFreeSlot(){
        for(Slot slot : _slots){
            if(slot.isFree()){
                return slot;
            }
        }
        return null;
    }

}
