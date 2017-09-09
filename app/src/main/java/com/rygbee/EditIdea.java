package com.rygbee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import jp.wasabeef.richeditor.RichEditor;

public class EditIdea extends AppCompatActivity {

    private RichEditor richEditor;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_idea);

        richEditor = (RichEditor) findViewById(R.id.richEditor);

        findViewById(R.id.btnBold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditor.setBold();
            }
        });

        findViewById(R.id.btnItalic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditor.setItalic();
            }
        });
        findViewById(R.id.btnUnderline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditor.setUnderline();
            }
        });

    }
}
