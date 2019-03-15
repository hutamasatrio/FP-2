package com.satrio.myapplication.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


    @Dao
    public interface DistributorDao {

        @Query("SELECT * FROM distributor")
        List<Distributor> getAll();

        @Query("SELECT * FROM distributor WHERE nama LIKE :nama ")
        Distributor findByName(String nama);

        @Insert
        void insertAll(Distributor distributor);

    }

