package com.example.crud_roomdb_operation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.crud_roomdb_operation.CRUD.AddUserFragment;
import com.example.crud_roomdb_operation.CRUD.DeleteUserFragment;
import com.example.crud_roomdb_operation.CRUD.ReadUserFragment;
import com.example.crud_roomdb_operation.CRUD.UpdateUserFragment;
import com.example.crud_roomdb_operation.databinding.FragmentMainBinding;

public class MainFragment extends Fragment implements View.OnClickListener {

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        FragmentMainBinding fragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        fragmentMainBinding.bnAddUser.setOnClickListener(this);
        fragmentMainBinding.bnViewUser.setOnClickListener(this);
        fragmentMainBinding.bnDeleteUser.setOnClickListener(this);
        fragmentMainBinding.bnUpdateUser.setOnClickListener(this);

        return fragmentMainBinding.getRoot();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.bn_add_user:

                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment()).addToBackStack(null).commit();

                break;

            case R.id.bn_view_user:

                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadUserFragment()).addToBackStack(null).commit();

                break;

            case R.id.bn_delete_user:

                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteUserFragment()).addToBackStack(null).commit();

                break;

            case R.id.bn_update_user:

                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateUserFragment()).addToBackStack(null).commit();
                break;
        }

    }

}
