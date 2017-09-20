package epam.com.converter;

/**
 * Created by homepc on 21.06.2017.
 */
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class dlg1 extends DialogFragment implements OnClickListener {

    final String LOG_TAG = "myLogs";
    Button btnEur, btnUsd, btnRub, btnPl;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Выберите валюту");
        View v = inflater.inflate(R.layout.dialog, null);
        v.findViewById(R.id.btnEur).setOnClickListener(this);
        v.findViewById(R.id.btnUsd).setOnClickListener(this);
        v.findViewById(R.id.btnRub).setOnClickListener(this);
        v.findViewById(R.id.btnPl).setOnClickListener(this);
        return v;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEur:
                
            dismiss();
        }
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog 1: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }
}
