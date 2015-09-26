package br.com.ceduphh.bruno.smsmanager;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SMSSenderActivity extends Activity {

    private static final int SELECIONAR_CONTATO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smssender);

        final EditText editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        SMSSenderActivity.this, 0, new Intent(), 0);

                /*smsManager.sendTextMessage(
                        "909088034063", null,
                        String.valueOf(editText.getText()), pendingIntent, null);
            */
            }}
                );

    }

    @Override
    public void startActivityForResult(Intent intent, int codigo) {
        super.startActivityForResult(intent, codigo);
    }
    public void onClick(View view){
        Uri uri = Uri.parse("content:\\com.android.contacts/contacts/1");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
}

    protected void  OnActivityResult(int requestCode, int resultCode, Intent intent){
        Uri uri = intent.getData();

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToNext();
        int nameColumn = cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME);
        Toast.makeText(this, "Nome:" + uri, Toast.LENGTH_SHORT).show();
        cursor.close();
    }


}
