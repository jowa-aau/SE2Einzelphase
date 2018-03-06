package com.wachner.johannes.se2einzelphase_palindromesolver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //views
    private TextView textViewInfoText;
    private EditText editTextPalindromeInput;
    private Button buttonCheckString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init views
        textViewInfoText = (TextView) findViewById(R.id.TextView_info);
        editTextPalindromeInput = (EditText) findViewById(R.id.EditText_palindrome_input);
        buttonCheckString = (Button) findViewById(R.id.Button_checkPalindrome);

        //button click listener
        buttonCheckString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputString = editTextPalindromeInput.getText().toString().trim();

                if (inputString.length() == 0){
                    textViewInfoText.setText(R.string.info_text_empty);
                }else if(inputString.length() <= 4){
                    textViewInfoText.setText(R.string.info_text_min_length);
                }else{
                    if (checkString(inputString)){
                        textViewInfoText.setText(R.string.info_text_true);
                    }else {
                        textViewInfoText.setText(R.string.info_text_false);
                    }
                }
            }
        });

    }

    //check string
    private boolean checkString(String inputString) {
        return inputString.equals(new StringBuilder(inputString).reverse().toString());

    }


}
