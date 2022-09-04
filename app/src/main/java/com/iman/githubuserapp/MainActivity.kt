package com.iman.githubuserapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }


    private val listUser: ArrayList<User>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val user = User(dataName[i],dataDescription[i], dataPhoto.getResourceId(i, -1))
                listUser.add(user)
            }
            return listUser
        }



    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            rvUser.layoutManager = GridLayoutManager(this, 2)
        }else{
            rvUser.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter
    }

    }