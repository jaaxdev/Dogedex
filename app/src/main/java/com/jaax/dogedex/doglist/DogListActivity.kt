package com.jaax.dogedex.doglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.jaax.dogedex.api.ApiResponsesStatus
import com.jaax.dogedex.databinding.ActivityDogListBinding
import com.jaax.dogedex.dogdetail.DogDetailActivity
import com.jaax.dogedex.dogdetail.DogDetailActivity.Companion.DOG_KEY

class DogListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDogListBinding
    private val dogListViewModel: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = DogAdapter()
        adapter.setOnItemClickListener {
            val intent = Intent(this, DogDetailActivity::class.java)
            intent.putExtra(DOG_KEY, it)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        dogListViewModel.dogList.observe(this) { dogList ->
            adapter.submitList(dogList)
        }

        dogListViewModel.status.observe(this) { status ->
            when(status) {
                ApiResponsesStatus.LOADING -> {
                    binding.loadingWheel.visibility = View.VISIBLE
                }
                ApiResponsesStatus.ERROR -> {
                    Toast.makeText(this, "Error al descargar datos", Toast.LENGTH_SHORT).show()
                    binding.loadingWheel.visibility = View.GONE
                }
                ApiResponsesStatus.SUCCESS -> {
                    binding.loadingWheel.visibility = View.GONE
                }
                else -> {
                    Toast.makeText(this, "Status desconocido", Toast.LENGTH_SHORT).show()
                    binding.loadingWheel.visibility = View.GONE
                }
            }
        }
    }
}