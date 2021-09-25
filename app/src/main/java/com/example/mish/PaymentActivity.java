package com.example.mish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import android.os.Bundle;

public class PaymentActivity extends AppCompatActivity {

    Encrypter en = new Encrypter();
    EditText Name;
    EditText ContactNo;
    EditText Email;
    EditText CardNumber;
    EditText Expirationdate;
    EditText CVC;
    RadioGroup Cardtype;
    Button Pay;
    DBAHelper DBA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Name = findViewById(R.id.InputName);
        ContactNo = findViewById(R.id.InputContact);
        Email = findViewById(R.id.InputEmail);
        CardNumber = findViewById(R.id.InputCardno);
        Cardtype = findViewById(R.id.cardType);
        Pay = findViewById(R.id.payBtn);


        Expirationdate = findViewById(R.id.InputExDate);
        CVC = findViewById(R.id.InputCvc);
        DBA = new DBAHelper(this);

        Pay.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                String name = Name.getText().toString();
                String contactno = ContactNo.getText().toString();
                String email = Email.getText().toString();
                RadioButton checkbtn = findViewById(Cardtype.getCheckedRadioButtonId());
                String cardtype = checkbtn.getText().toString();
                String cardno = en.caesarCipherEncrypt(CardNumber.getText().toString());
                String expdate = Expirationdate.getText().toString();
                String cvc = CVC.getText().toString();


                if (checkDataEntered() == false)
                    Toast.makeText(PaymentActivity.this, "All fields Required", Toast.LENGTH_SHORT).show();
                else{
                    DBA.insertdata(name, contactno, email, cardtype, cardno);
                    Toast.makeText(PaymentActivity.this, "Success", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), ViewPayActivity.class);
                    intent.putExtra("kcardno", cardno);
                    intent.putExtra("kcardtype", cardtype);
                    startActivity(intent);

                }

            }

            boolean isEmpty(EditText text) {
                CharSequence str = text.getText().toString();
                return TextUtils.isEmpty(str);
            }
            boolean isEmptyR(RadioGroup text) {
                //CharSequence str;
                RadioButton checkbtn = findViewById(Cardtype.getCheckedRadioButtonId());
                CharSequence str = checkbtn.getText().toString();
                //str = cardtype.getText().toString();
                return TextUtils.isEmpty(str);
            }

            boolean isEmail(EditText text) {   //check valid Email
                CharSequence email = text.getText().toString();
                return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
            }

            boolean checkDataEntered() {  //validations

                if (isEmpty(Name) == true) {
                    Name.setError("name is required!");
                    return false;
                }
                if (isEmpty(ContactNo) == true) {
                    Name.setError("name is required!");
                    return false;
                }
                if (isEmail(Email) == false) {
                    Email.setError("Enter valid email!");
                    return false;
                }
                if (isEmpty(CardNumber) == true) {
                    CardNumber.setError("Card No is required!");
                    return false;
                }
                if (isEmptyR(Cardtype) == true) {
                    Name.setError("name is required!");
                    return false;
                }

                if (isEmpty(Expirationdate) == true) {
                    Expirationdate.setError("Expirationdate is required!");
                    return false;
                }
                if (isEmpty(CVC) == true) {
                    CVC.setError("CVC is required!");
                    return false;
                } else
                    return true;

            }


        });


    }}