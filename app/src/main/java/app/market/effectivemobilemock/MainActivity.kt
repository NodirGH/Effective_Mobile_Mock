package app.market.effectivemobilemock

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import app.market.effectivemobilemock.databinding.ActivityMainBinding
import app.market.toolkit.extensions.hideAnimWithSlideDown
import app.market.toolkit.extensions.showAnimWithSlideUp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentMain) as NavHostFragment
        binding.bnvMain.setupWithNavController(navHostFragment.navController)
        binding.bnvMain.itemIconTintList = null
        navController = navHostFragment.navController
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment,
                R.id.favoritesFragment,
                R.id.profileFragment -> {
                    binding.bnvMain.showAnimWithSlideUp()
                }
                else -> {
                    binding.bnvMain.hideAnimWithSlideDown()
                }
            }
        }
    }
}