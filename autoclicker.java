import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.MotionEvent;

public class ClickSimulator {

    public static void clickOnCoordinates(final int x, final int y) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendPointerSync(MotionEvent.obtain(
                            SystemClock.uptimeMillis(),
                            SystemClock.uptimeMillis(),
                            MotionEvent.ACTION_DOWN, x, y, 0));
                    inst.sendPointerSync(MotionEvent.obtain(
                            SystemClock.uptimeMillis(),
                            SystemClock.uptimeMillis(),
                            MotionEvent.ACTION_UP, x, y, 0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

//ClickSimulator.clickOnCoordinates(100, 200);
