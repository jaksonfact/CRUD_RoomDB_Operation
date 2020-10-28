package com.example.crud_roomdb_operation.CRUD;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.crud_roomdb_operation.MainActivity;
import com.example.crud_roomdb_operation.R;
import com.example.crud_roomdb_operation.database.User;
import com.example.crud_roomdb_operation.databinding.FragmentReadUserBinding;

import java.util.List;

public class ReadUserFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        FragmentReadUserBinding fragmentReadUserBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_read_user, container, false);

        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();

        String info = "";

        for(User user: users){

            int id = user.getId();

            String name = user.getName();

            String email = user.getEmail();

            info = info +"id : "+ id+"\n"+ "name : " + name+" \n" + "Email : " + email+ "\n";
        }

        fragmentReadUserBinding.userDetails.setText(info);

        return fragmentReadUserBinding.getRoot();
    }
}

