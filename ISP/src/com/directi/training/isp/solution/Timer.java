import java.util.TimerTask;

public class Timer {
    public void register(long timeOut, final ITimed timedDoor) {
        java.util.Timer timerUtility = new java.util.Timer();
        timerUtility.schedule(new TimerTask() {
            @Override
            public void run() {
                timedDoor.timeOutCallback();
            }
        }, timeOut);
    }
}
