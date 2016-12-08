package com.example.davidzhang.gesturedatacapture;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
//import android.support.v7.app.AppCompatActivity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.hardware.SensorEventListener;
import android.app.Activity;


public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager senSensorManager;
    private Sensor senAccelerometer;
    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        // If sensor is unreliable, then just return
//        if (sensorEvent.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) {
//            return;
//        }


        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            detectMotion(sensorEvent);
        }
//            Sensor mySensor = sensorEvent.sensor;
//
//            if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
//                float x = sensorEvent.values[0];
//                float y = sensorEvent.values[1];
//                float z = sensorEvent.values[2];
//
//                System.out.println("X = " + x);
//                System.out.println("Y = " + y);
//                System.out.println("Z = " + z);

//            long curTime = System.currentTimeMillis();
//
//            if ((curTime - lastUpdate) > 100) {
//                long diffTime = (curTime - lastUpdate);
//                lastUpdate = curTime;
//
//                float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 10000;
//
//                if (speed > SHAKE_THRESHOLD) {
//
//                }
//
//                last_x = x;
//                last_y = y;
//                last_z = z;


//            }
//        }
    }

    public void detectMotion(SensorEvent sensorEvent) {
        long now = System.currentTimeMillis();

        if ((now - lastUpdate) > 100) {
            lastUpdate = now;

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            System.out.println("X = " + x);
            System.out.println("Y = " + y);
            System.out.println("Z = " + z);
        }
    }




    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        senSensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
