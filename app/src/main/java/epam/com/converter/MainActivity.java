package epam.com.converter;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    DialogFragment dlg1;
    static ImageButton btnDlg1;
    static ImageButton btnDlg2;

    private static double multiplier = 1;
    private static double multiplier2 = 1;

    double amount;
    Button convert;
    EditText input;
    TextView output;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         input = (EditText)findViewById(R.id.inputText);
        output = (TextView)findViewById(R.id.output);
        btnDlg1= (ImageButton)findViewById(R.id.btnDlg1);
        btnDlg2= (ImageButton)findViewById(R.id.btnDlg2);
        convert =(Button)findViewById(R.id.convert);

        btnDlg1.setOnClickListener(this);
        btnDlg2.setOnClickListener(this);
        convert.setOnClickListener(this);

        new ParseTask().execute();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDlg1:
                dlg1 = new dlg1();
                dlg1.show(getFragmentManager(), "dlg1");
                break;

            case R.id.convert:
                String strAmount = input.getText().toString();
                if (strAmount.isEmpty()) {break;}
                else{
                amount = Double.parseDouble(strAmount) / getMultiplier() * getMultiplier2();
                output.setText(String.valueOf(amount));
                break;}

            case R.id.btnDlg2:
                dlg1 = new dlg1();
                dlg1.show(getFragmentManager(), "dlg1");
                break;
        }
    }


    public static void setMultiplier(double multiplier) {
        MainActivity.multiplier = multiplier;
    }
    public static void setMultiplier2(double multiplier2) {MainActivity.multiplier2 = multiplier2;}

    public static double getMultiplier() {return multiplier;}

    public static double getMultiplier2() {return multiplier2;}
}
