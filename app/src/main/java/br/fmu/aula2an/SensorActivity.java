package br.fmu.aula2an;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import java.util.List;

public class SensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for( Sensor sensor: listaSensores ) {
            System.out.println(sensor.getName());
        }
    }
}