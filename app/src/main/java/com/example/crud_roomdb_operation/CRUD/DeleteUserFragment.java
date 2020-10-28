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
import com.example.crud_roomdb_operation.databinding.FragmentDeleteUserBinding;

public class DeleteUserFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final FragmentDeleteUserBinding deleteUserBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_delete_user,container,false);


        deleteUserBinding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();

                if(deleteUserBinding.deleteId.getText().toString().length()>0)
                    user.setId(Integer.parseInt(deleteUserBinding.deleteId.getText().toString()));

                MainActivity.myAppDatabase.myDao().deleteUser(user);
                Toast.makeText(getContext(), "User deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });

        return deleteUserBinding.getRoot();
    }

}
