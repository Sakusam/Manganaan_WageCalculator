package mcm.edu.ph.manganaan_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
//"from the teams chat"
//Wage Calculator
// Regular Employee:
// 1-8 hours(regular work time): 100 pesos per hour
// Probationary Employee:
// 1-8 hours: 90 pesos per hour
// Part-time workers:
// 1-8 hours: 75 pesos per hour

public class Display extends AppCompatActivity {

    TextView temployeename, temployeetype, thoursrender, ttotalwage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        temployeename = findViewById(R.id.temployeename);
        temployeetype = findViewById(R.id.temployeetype);
        thoursrender = findViewById(R.id.thoursrender);
        ttotalwage = findViewById(R.id.ttotalwage);


        Intent i = getIntent();
        String employeetype = i.getStringExtra("type");
        String employeeName = i.getStringExtra("empName");
        Double employeeHours = Double.parseDouble(i.getStringExtra("hours"));

        temployeename.setText("Employee Name: " + employeeName);
        temployeetype.setText("Employee Type: " + String.valueOf(employeetype));
        thoursrender.setText("Hours Rendered" + String.valueOf(employeeHours));

        Double TotalWage = 0.0;



        if(employeeHours > 8.0){

        }
        else{
            if(employeetype.equals("Full-time")) {
                TotalWage = employeeHours * 100;
                ttotalwage.setText("Total Wage: " + String.valueOf(TotalWage));
            }
            else if (employeetype.equals("Part-time")) {
                TotalWage = employeeHours * 75;
                ttotalwage.setText("Total Wage: " + String.valueOf(TotalWage));
            }
            else{
                TotalWage = employeeHours * 90;
                ttotalwage.setText("Total Wage: " +String.valueOf(TotalWage));
            }
            if (employeetype.equals("Probationary")){
                TotalWage = 720 + (100 * (employeeHours - 8.0));
                ttotalwage.setText("Total Wage with Overtime: ₱" + String.valueOf(TotalWage));
            }
            }

        }

    }