package com.platzi.blogapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseFirestore.getInstance()

        //Consultar informacion
        db.collection("ciudades").document("NY").addSnapshotListener { value, error ->
            value?.let{ document ->
                val ciudad = document.toObject(Ciudad::class.java)
                Log.d("Firebase", "Color: ${ciudad?.color}")
                Log.d("Firebase", "Population: ${ciudad?.population}")
                Log.d("Firebase", "Postal code: ${ciudad?.pc}")
            }
    }

        //Ingresar informacion
        db.collection("ciudades").document("LA").set(Ciudad(3000000,"Red")).addOnSuccessListener {
            Log.d("Firebase", "Se guardo la ciudad correctamente.")
        }.addOnFailureListener{ error ->
            Log.e("FirebaseError", error.toString())
        }
    }
}

data class Ciudad(val population: Int = 0,
                  val color: String = "",
                  val pc: Int = 0)