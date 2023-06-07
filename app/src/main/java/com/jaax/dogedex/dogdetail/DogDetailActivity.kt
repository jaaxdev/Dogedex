package com.jaax.dogedex.dogdetail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.jaax.dogedex.R
import com.jaax.dogedex.databinding.ActivityDogDetailBinding
import com.jaax.dogedex.doglist.Dog

class DogDetailActivity: AppCompatActivity() {

    companion object {
        val DOG_KEY = "dog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dogExtra = intent?.extras?.getParcelable<Dog>(DOG_KEY)

        if(dogExtra == null) {
            Toast.makeText(this, R.string.dog_not_found, Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        binding.dogIndex.text = getString(R.string.dog_index_format, dogExtra.index)
        binding.lifeExpectancy.text = getString(R.string.dog_life_expectancy_format, dogExtra.lifeExpectancy)
        binding.dog = dogExtra
        binding.dogImage.load(dogExtra.imageURL)
        binding.closeButton.setOnClickListener {
            finish()
        }
    }
}