package com.beyzaterzioglu.sanatkitabifragment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.beyzaterzioglu.sanatkitabifragment.R
import com.beyzaterzioglu.sanatkitabifragment.adapter.picAdapter
import com.beyzaterzioglu.sanatkitabifragment.databinding.ActivityMainBinding
import com.beyzaterzioglu.sanatkitabifragment.model.Pic
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import com.beyzaterzioglu.sanatkitabifragment.room_db.PicDatabase

import io.reactivex.rxjava3.disposables.CompositeDisposable



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navigationController : NavController




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        navigationController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this,navigationController)



    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.pic_menu, menu)
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragment)
        return navController.navigateUp()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.add_pic) {
            val action = ArtListDirections.actionArtListToDetailsFragment("new",0)
            Navigation.findNavController(this, R.id.fragment).navigate(action)
            return true
        }

        else {
            return super.onOptionsItemSelected(item)
        }
    }


}