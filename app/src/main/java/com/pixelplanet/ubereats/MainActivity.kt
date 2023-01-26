package com.pixelplanet.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.pixelplanet.ubereats.base.BaseActivity
import com.pixelplanet.ubereats.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        val navController = findNavController(R.id.navHost)
        navController.setGraph(R.navigation.navigation)
        mainBinding.bottomNav.setupWithNavController(navController)

        mainBinding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bnv_home -> {
                    navController.setGraph(R.navigation.navigation)
                }
            }
            true
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.homeFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
        showBottomNav()
    }
    private fun showBottomNav(){
        mainBinding.bottomNav.isVisible = true
    }
    private fun hideBottomNav(){
        mainBinding.bottomNav.isVisible = false
    }

}