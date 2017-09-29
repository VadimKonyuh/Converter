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

import static epam.com.converter.ParseTask.LOG_TAG;
public class dlg1 extends DialogFragment implements OnClickListener {

    Double index;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Выберите валюту");
        View v = inflater.inflate(R.layout.dialog, null);
        v.findViewById(R.id.btnRub).setOnClickListener(this);
        v.findViewById(R.id.btnEur).setOnClickListener(this);
        v.findViewById(R.id.btnUsd).setOnClickListener(this);
        v.findViewById(R.id.btnPln).setOnClickListener(this);
        v.findViewById(R.id.btnAUD).setOnClickListener(this);
        v.findViewById(R.id.btnCAD).setOnClickListener(this);
        v.findViewById(R.id.btnSEK).setOnClickListener(this);
        v.findViewById(R.id.btnBRZ).setOnClickListener(this);
        return v;
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnRub:
                MainActivity.btnDlg1.setImageResource(R.drawable.ru);
                index = ParseTask.map.get("RUB");
                Log.d(LOG_TAG, Double.toString(index));
                MainActivity.setMultiplier(index);
                dismiss();
                break;


            case R.id.btnEur:
                MainActivity.btnDlg1.setImageResource(R.drawable.eu);
                index = 1.;
                Log.d(LOG_TAG, Double.toString(index));
                MainActivity.setMultiplier(1.);
                dismiss();

                break;

            case R.id.btnUsd:
                MainActivity.btnDlg1.setImageResource(R.drawable.us);
                Double index = ParseTask.map.get("USD");
                Log.d(LOG_TAG, Double.toString(index));
                MainActivity.setMultiplier(index);
                dismiss();
                break;

            case R.id.btnPln:
                MainActivity.btnDlg1.setImageResource(R.drawable.pl);
                index = ParseTask.map.get("PLN");
                Log.d(LOG_TAG, Double.toString(index));
                MainActivity.setMultiplier(index);
                dismiss();
                break;

            case R.id.btnAUD:
                MainActivity.btnDlg1.setImageResource(R.drawable.aud);
                index = ParseTask.map.get("AUD");
                Log.d(LOG_TAG, Double.toString(index));
                MainActivity.setMultiplier(index);
                dismiss();
                break;

            case R.id.btnCAD:
                MainActivity.btnDlg1.setImageResource(R.drawable.cad);
                index = ParseTask.map.get("CAD");
                Log.d(LOG_TAG, Double.toString(index));
                MainActivity.setMultiplier(index);
                dismiss();
                break;

            case R.id.btnSEK:
                MainActivity.btnDlg1.setImageResource(R.drawable.sek);
                index = ParseTask.map.get("SEK");
                Log.d(LOG_TAG, Double.toString(index));
                MainActivity.setMultiplier(index);
                dismiss();
                break;

            case R.id.btnBRZ:
                MainActivity.btnDlg1.setImageResource(R.drawable.brz);
                index = ParseTask.map.get("BRL");
                Log.d(LOG_TAG, Double.toString(index));
                MainActivity.setMultiplier(index);
                dismiss();
                break;
        }
    }


    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }
}
