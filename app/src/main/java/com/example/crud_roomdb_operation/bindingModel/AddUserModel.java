package com.example.crud_roomdb_operation.bindingModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.crud_roomdb_operation.database.MyAppDatabase;
import com.example.crud_roomdb_operation.database.MyDao;
import com.example.crud_roomdb_operation.database.User;

public class AddUserModel extends AndroidViewModel {

    MyDao myDao;
    public AddUserModel(@NonNull Application application) {
        super(application);
    }
    void insert(User user) {
       myDao.addUser(user);
    }
}

