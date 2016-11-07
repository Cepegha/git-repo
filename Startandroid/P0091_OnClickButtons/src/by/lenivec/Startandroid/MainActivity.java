package by.lenivec.Startandroid;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tvOut;
    Button btnOk;
    Button btnCancel;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // найдем View-элементы
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        View.OnClickListener oclBtnOk = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                tvOut.setText("Press OK");
            }
        };

        View.OnClickListener oclBtnCancel=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change text in TextView
                tvOut.setText("Press Cancel");            }
        };

        // присвоим обработчик кнопке Cancel (btnCancel)
        btnCancel.setOnClickListener(oclBtnCancel);

        // присвоим обработчик кнопке OK (btnOk)
        btnOk.setOnClickListener(oclBtnOk);
    }
}
