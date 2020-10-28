package com.example.crud_roomdb_operation.CRUD;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.crud_roomdb_operation.MainActivity;
import com.example.crud_roomdb_operation.R;
import com.example.crud_roomdb_operation.database.User;
import com.example.crud_roomdb_operation.databinding.FragmentUpdateUserBinding;

public class UpdateUserFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final FragmentUpdateUserBinding fragmentUpdateUserBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_update_user,container,false);

        fragmentUpdateUserBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(fragmentUpdateUserBinding.id.getText().toString());
                String name = fragmentUpdateUserBinding.name.getText().toString();
                String email = fragmentUpdateUserBinding.email.getText().toString();

                User user = new User();

                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().updateUser(user);

                Toast.makeText(getContext(), "User updated successfully", Toast.LENGTH_SHORT).show();

            }
        });


        return fragmentUpdateUserBinding.getRoot();

    }

}
