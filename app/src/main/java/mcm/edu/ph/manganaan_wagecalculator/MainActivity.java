package mcm.edu.ph.manganaan_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText empname, emphours;
    RadioGroup emptype;
    RadioButton bselected;
    Button bcalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empname = findViewById(R.id.employeename);
        emphours = findViewById(R.id.employeeHours);
        emptype = findViewById(R.id.employeetype);
        bcalculate = findViewById(R.id.calculate);
        bcalculate.setOnClickListener(this);
    }


    public void onClick(View v) {


        switch(v.getId()){
            case R.id.calculate:
                int selectedEmployeeType = emptype.getCheckedRadioButtonId();
                bselected = findViewById(selectedEmployeeType);

                String type = bselected.getText().toString();
                String name = empname.getText().toString();
                String totalHours = (emphours.getText().toString());

                Intent intent = new Intent(this,Display.class);

                intent.putExtra("type",type);
                intent.putExtra("empName",name);
                intent.putExtra("hours",totalHours);
                startActivity(intent);

                break;
        }
    }
}