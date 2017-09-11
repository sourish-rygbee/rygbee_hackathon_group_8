package com.rygbee;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.rygbee.Response.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateInfoFragment extends Fragment {


    public UpdateInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_update_info, container, false);

        MaterialEditText fn= view.findViewById(R.id.fn);
        MaterialEditText ln= view.findViewById(R.id.sn);
        MaterialEditText location= view.findViewById(R.id.location);
        MaterialEditText desig= view.findViewById(R.id.designation);
        MaterialEditText affi= view.findViewById(R.id.affilation);
        MaterialEditText email= view.findViewById(R.id.email);
        MaterialEditText desc= view.findViewById(R.id.desc);


        fn.setFloatingLabel(MaterialEditText.FLOATING_LABEL_HIGHLIGHT);
        fn.setFloatingLabelText("First Name");

        ln.setFloatingLabel(MaterialEditText.FLOATING_LABEL_HIGHLIGHT);
        ln.setFloatingLabelText("Last Name");

        email.setFloatingLabel(MaterialEditText.FLOATING_LABEL_HIGHLIGHT);
        email.setFloatingLabelText("Official Email");

        desig.setFloatingLabel(MaterialEditText.FLOATING_LABEL_HIGHLIGHT);
        desig.setFloatingLabelText("Designation");

        affi.setFloatingLabel(MaterialEditText.FLOATING_LABEL_HIGHLIGHT);
        affi.setFloatingLabelText("Affilation");

        Bundle bundle=getArguments();
        User u = bundle.getParcelable("Data");
        assert u != null;
        fn.setText(u.getFirstname());
        ln.setText(u.getLastname());
        desc.setText(u.getAboutme());
        location.setText(u.getLocation());
        email.setText(u.getEmail());
        desig.setText(u.getDesignation());
        affi.setText(u.getAffiliation());
        return view;
    }

}
