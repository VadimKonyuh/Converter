package epam.com.converter;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    DialogFragment dlg1;
    ImageButton btnDlg1;
    Button convert;
    double amount;
    EditText input;
    TextView output;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         input = (EditText)findViewById(R.id.inputText);
        output = (TextView)findViewById(R.id.output);
        btnDlg1= (ImageButton)findViewById(R.id.btnDlg1);
        btnDlg1.setOnClickListener(this);
        convert =(Button)findViewById(R.id.convert);
        convert.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDlg1:
                dlg1 = new dlg1();
                dlg1.show(getFragmentManager(), "dlg1");
                break;

            case R.id.convert:
                String strAmount = input.getText().toString();
                amount = Integer.parseInt(strAmount) * 23;
                output.setText(String.valueOf(amount));
                break;

        }
    }
}