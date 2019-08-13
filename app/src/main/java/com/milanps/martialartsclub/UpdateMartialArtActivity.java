package com.milanps.martialartsclub;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.milanps.martialartsclub.Model.DatabaseHandler;
import com.milanps.martialartsclub.Model.MartialArt;

import java.util.ArrayList;

public class UpdateMartialArtActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHandler databaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_martial_art);

        databaseHandler = new DatabaseHandler(UpdateMartialArtActivity.this);
        modifyUserInterface();
    }

    private void modifyUserInterface() {
        ArrayList<MartialArt> martialArtObjects = databaseHandler.returnAllMartialArtObjects();
        if (martialArtObjects.size() > 0) {
            ScrollView scrollView = new ScrollView(UpdateMartialArtActivity.this);
            GridLayout gridLayout = new GridLayout(UpdateMartialArtActivity.this);
            gridLayout.setRowCount(martialArtObjects.size());
            gridLayout.setColumnCount(5);

            TextView[] idTextView = new TextView[martialArtObjects.size()];
            EditText[][] edtNamesPricesAndColors = new EditText[martialArtObjects.size()][3];
            Button[] modifyButtons = new Button[martialArtObjects.size()];

            Point screenSize = new Point();
            getWindowManager().getDefaultDisplay().getSize(screenSize);

            int screenWidth = screenSize.x;
            int index = 0;
            for (MartialArt martialArtObject : martialArtObjects) {

                idTextView[index] = new TextView(UpdateMartialArtActivity.this);
                idTextView[index].setGravity(Gravity.CENTER);
                idTextView[index].setText(martialArtObject.getMartialArtID() + "");

                edtNamesPricesAndColors[index][0] = new EditText(UpdateMartialArtActivity.this);
                edtNamesPricesAndColors[index][1] = new EditText(UpdateMartialArtActivity.this);
                edtNamesPricesAndColors[index][2] = new EditText(UpdateMartialArtActivity.this);

                edtNamesPricesAndColors[index][0].setText(martialArtObject.getMartialArtName());
                edtNamesPricesAndColors[index][1].setText(martialArtObject.getMartialArtPrice() + "");
                edtNamesPricesAndColors[index][1].setInputType(InputType.TYPE_CLASS_NUMBER);
                edtNamesPricesAndColors[index][2].setText(martialArtObject.getMartialArtColor());

                edtNamesPricesAndColors[index][0].setId(martialArtObject.getMartialArtID() + 10);
                edtNamesPricesAndColors[index][1].setId(martialArtObject.getMartialArtID() + 20);
                edtNamesPricesAndColors[index][2].setId(martialArtObject.getMartialArtID() + 30);

                modifyButtons[index] = new Button(UpdateMartialArtActivity.this);
                modifyButtons[index].setText("Modify");
                modifyButtons[index].setId(martialArtObject.getMartialArtID());
                modifyButtons[index].setOnClickListener(UpdateMartialArtActivity.this);

                gridLayout.addView(idTextView[index], (int) (screenWidth * 0.05), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtNamesPricesAndColors[index][0], (int) (screenWidth * 0.27), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtNamesPricesAndColors[index][1], (int) (screenWidth * 0.18), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtNamesPricesAndColors[index][2], (int) (screenWidth * 0.20), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(modifyButtons[index], (int) (screenWidth * 0.30), ViewGroup.LayoutParams.WRAP_CONTENT);


                index++;

            }

            scrollView.addView(gridLayout);
            setContentView(scrollView);

        }

    }

    @Override
    public void onClick(View view) {

        int martialArtObjectID = view.getId();
        EditText edtMartialArtName = (EditText) findViewById(martialArtObjectID + 10);
        EditText edtMartialArtPrice = (EditText) findViewById(martialArtObjectID + 20);
        EditText edtMartialArtColor = (EditText) findViewById(martialArtObjectID + 30);

        String martialArtNameStringValue = edtMartialArtName.getText().toString();
        String martialArtPriceStringValue = edtMartialArtPrice.getText().toString();
        String martialArtColorStringValue = edtMartialArtColor.getText().toString();

        try {
            double martialArtPriceDoubleValue = Double.parseDouble(martialArtPriceStringValue);

            databaseHandler.modifyMartialArtObject(martialArtObjectID, martialArtNameStringValue, martialArtPriceDoubleValue, martialArtColorStringValue);
            Toast.makeText(UpdateMartialArtActivity.this, "This Martial Art Object is updated", Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e) {

        }


    }
}
