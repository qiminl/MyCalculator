package com.example.liuqimin.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements TextWatcher, View.OnClickListener{

    private static final String Debug_Tag = "Mycalculator";

    // key for saving states
    private static final String Assignmentkey = "Assignment";
    private double assignmentMark;
    private EditText assignmentEdit;

    private static final String Participatekey = "Participate";
    private double participateMark;
    private EditText participateEdit;

    private static final String Projectkey = "Project";
    private double projectMark;
    private EditText projectEdit;

    private static final String Quizkey = "Quiz";
    private double quizMark;
    private EditText quizEdit;

    private static final String Examkey = "Exam";
    private double examMark;
    private EditText examEdit;

    private TextView finalMarkView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignmentEdit =(EditText) findViewById(R.id.assignTextEdit);
        assignmentEdit.addTextChangedListener(this);
        assignmentEdit.setRawInputType(InputType.TYPE_CLASS_NUMBER |
                                        InputType.TYPE_NUMBER_FLAG_DECIMAL);
        finalMarkView = (TextView) findViewById(R.id.finalMarkTextView);
        assignmentMark = 0;



        assignmentEdit =(EditText) findViewById(R.id.assignTextEdit);
        assignmentEdit.addTextChangedListener(this);
        finalMarkView = (TextView) findViewById(R.id.finalMarkTextView);
        assignmentMark = 0;

    }

    // to update the final grade
    private void updateStandard(){
        double finalmark = 0;
            finalmark = assignmentMark * 15 / 100;
            finalMarkView.setText(String.format("%.02f", finalmark));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String str = s.toString();
        Log.d(Debug_Tag, "str = 123w" + str);
        if (str == null){

            Log.d(Debug_Tag, "str = null");
        }
        else if(str == ""){
            Log.d(Debug_Tag, "str = nothing");
        }
        else if(str == " "){
            Log.d(Debug_Tag, "str = space");
        }
       // else assignmentMark = Double.parseDouble(s.toString());
     //   Log.d(Debug_Tag, "assignmentMark = " + assignmentMark);
        updateStandard();

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
