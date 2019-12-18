package io.github.kyleoakes.cs338_assig7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<Integer, String> courseNames = new HashMap<>();
    private Map<Integer, String> courseDescriptions = new HashMap<>();

    EditText etInput;
    Button btnSubmit;
    TextView tvCourseList;
    TextView tvCourseDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadCourseNames();
        loadCourseDescriptions();

        etInput = findViewById(R.id.etInput);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvCourseList = findViewById(R.id.tvCourseList);
        tvCourseDesc = findViewById(R.id.tvCourseDescription);

        setupSubmitButton(btnSubmit);
        setupCourseList();
    }

    // Sets up the submit button by adding an action listener to handle clicks
    private void setupSubmitButton(Button button)
    {
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (! etInput.getText().toString().equals(""))
                {
                    String input = etInput.getText().toString();
                    if (isOnlyDigits(input))
                    {
                        int courseNum = Integer.parseInt(input);
                        displayCourseDescription(courseNum);
                    }
                    else
                    {
                        String output;
                        output = getString(R.string.invalidCourseNumNonInt);
                        tvCourseDesc.setText(output);
                    }
                }
                else
                {
                    String output;
                    output = getString(R.string.invalidCourseNumBlank);
                    tvCourseDesc.setText(output);
                }
            }
        });
    }

    private void displayCourseDescription(int courseNum)
    {
        String output = "";

        Object courseName = courseNames.get(courseNum);
        Object courseDesc = courseDescriptions.get(courseNum);

        if (courseName != null && courseDesc != null)
        {
            courseName = courseName.toString();
            courseDesc = courseDesc.toString();
            output += "Course Description:\n" + "CST " + courseNum + ", " + courseName + ": "
                    + courseDesc;
        }
        else
        {
            output += getString(R.string.invalidCourseNumNotFound);
        }



        tvCourseDesc.setText(output);
    }

    private boolean isOnlyDigits(String input)
    {
        boolean foundIllegalChar = false;
        for (int c = 0; c < etInput.length() && !foundIllegalChar; c++)
        {
            if (!Character.isDigit(input.charAt(c)))
            {
                foundIllegalChar = true;
            }
        }
        return !foundIllegalChar;
    }

    private void setupCourseList()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getString(R.string.courseListTitle));

        for ( Map.Entry<Integer,String> entry : courseNames.entrySet())
        {
            stringBuilder.append("\n" + "➣CST " + entry.getKey() + "\n    \"" + entry.getValue() + "\"");
        }

        stringBuilder.append("\n");
        tvCourseList.setText(stringBuilder.toString());
    }

    private void loadCourseNames ()
    {
        courseNames.put(300, getString(R.string.cst300Name));
        courseNames.put(338, getString(R.string.cst338Name));
        courseNames.put(363, getString(R.string.cst363Name));
        courseNames.put(334, getString(R.string.cst334Name));
        courseNames.put(311, getString(R.string.cst311Name));
        courseNames.put(336, getString(R.string.cst336Name));
        courseNames.put(462, getString(R.string.cst462Name));
        courseNames.put(328, getString(R.string.cst328Name));
        courseNames.put(370, getString(R.string.cst370Name));
        courseNames.put(383, getString(R.string.cst383Name));
        courseNames.put(329, getString(R.string.cst329Name));
        courseNames.put(438, getString(R.string.cst438Name));
        courseNames.put(499, getString(R.string.cst499Name));
    }

    private void loadCourseDescriptions () {
        courseDescriptions.put(300, getString(R.string.cst300Desc));
        courseDescriptions.put(338, getString(R.string.cst338Desc));
        courseDescriptions.put(363, getString(R.string.cst363Desc));
        courseDescriptions.put(334, getString(R.string.cst334Desc));
        courseDescriptions.put(311, getString(R.string.cst311Desc));
        courseDescriptions.put(336, getString(R.string.cst336Desc));
        courseDescriptions.put(462, getString(R.string.cst462Desc));
        courseDescriptions.put(328, getString(R.string.cst328Desc));
        courseDescriptions.put(370, getString(R.string.cst370Desc));
        courseDescriptions.put(383, getString(R.string.cst383Desc));
        courseDescriptions.put(329, getString(R.string.cst329Desc));
        courseDescriptions.put(438, getString(R.string.cst438Desc));
        courseDescriptions.put(499, getString(R.string.cst499Desc));
    }
}