package com.example.kotlin_dio

import UserDao
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class DesafioMainActivity: AppCompatActivity() {
    fun main() {
        //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
        // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
        val userDao = UserDao()

       override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
           // setContentView(R.layout.activity_main)
            setContentView(MainActi)
            setContent{
                MainActivity()
            }
            initView()
            setValuesToViews()

            addAlunoButton.setOnClickListener {
                val intent = Intent(this, DesafioMain::class.java)
                ActivityCompat.startActivityForResult(intent, 1)
            }
        }
        val addAlunoButton = findViewById<Button>(R.id.addAlunoButton)
        addAlunoButton.setOnClickListener {
            // Return note text to the NotesActivity
            //val data = Intent()
            userDao.enroll("Pedro", "pedro@gmail.com")
            setResult(Activity.RESULT_OK, data)
            // Close current window
            onBackPressed()
        }
        fun setValuesToViews() {
            userDao.users[0] = intent.getStringExtra("nome")
            userDao.users[1] = intent.getStringExtra("email")
        }


    }

}