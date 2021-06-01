package com.piappstudio.offlineexam.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.piappstudio.corelibrary.model.api.pojo.DynamicUI
import com.piappstudio.corelibrary.model.api.pojo.Page
import com.piappstudio.offlineexam.R
import com.piappstudio.offlineexam.common.CacheManager
import com.piappstudio.offlineexam.common.Resource
import com.piappstudio.offlineexam.databinding.ActivityMainBinding
import com.piappstudio.offlineexam.ui.list.ListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : PIBaseActivity() {

    private lateinit var binding:ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        initUI()
    }


    // To initialize the UI elements
    private fun initUI() {
        // To check the internet availability
        if(isInternetAvailable(this)) {
            viewModel.loadFromInternet().observe(this, {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        showProgressDialog("Loading")
                    }
                    Resource.Status.SUCCESS -> {
                        dismissProgressDialog("Loading")
                        lifecycleScope.launch(Dispatchers.IO) {
                            // Store the response in cache folder
                            val json = Gson().toJson(it?.data)
                            CacheManager().saveJson(baseContext, json)
                        }
                        loadFragment(it.data?.page)
                    }
                    else -> {
                        dismissProgressDialog("Loading")
                    }
                }
            })
        } else {
            // To load the json from cache
            lifecycleScope.launch(Dispatchers.IO) {
                val json = CacheManager().retrieveJson(baseContext)
                lifecycleScope.launch(Dispatchers.Main) {
                    val data = Gson().fromJson(json, DynamicUI::class.java)
                    loadFragment(data?.page)
                }
            }

        }
    }

    // To load the fragment based on response
    private fun loadFragment(page: Page?) {
        page?.let {
            val fragment = ListFragment.newInstance(page)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, fragment)
            transaction.commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}