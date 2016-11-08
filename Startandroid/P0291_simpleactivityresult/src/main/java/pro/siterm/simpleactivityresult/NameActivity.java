package pro.siterm.simpleactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Cepegha@gmail.com on 08.11.2016.
 */
public class NameActivity extends Activity implements View.OnClickListener{
    EditText etName;
    Button btnOK;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);

        etName = (EditText) findViewById(R.id.etName);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);
    }

    /*
    В методе onClick мы создаем Intent и помещаем в него данные из поля ввода под именем name. Обратите внимание, мы никак не адресуем этот Intent. Т.е. ни класс, ни action мы не указываем. И получается, что непонятно куда пойдет этот Intent. Но метод setResult знает, куда его адресовать - в «родительское» Activity, в котором был вызван метод startActivityForResult. Также в setResult мы передаем константу RESULT_OK, означающую успешное завершение вызова. И именно она передастся в параметр resultCode метода onActivityResult в MainActivity.java.
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", etName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
