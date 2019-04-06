package com.lequtera.bms.webview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomDialogue extends AppCompatDialogFragment {
    public TextView name,capacity,facility;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialogue_layout,null);
        builder.setView(view);
        name = view.findViewById(R.id.customDialogueBoothName);
        capacity = view.findViewById(R.id.customDialogueBoothCapacity);
        facility = view.findViewById(R.id.customDialogueBoothFacility);
        return builder.create();
    }


}
