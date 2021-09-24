package com.example.exchange.data.db;

import android.content.Context;

import com.example.exchange.data.db.model.DaoMaster;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DBOpenHelper extends DaoMaster.OpenHelper {

    @Inject
    public DBOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        switch (oldVersion){
            case 1:
            case 2:
        }
    }
}
