package com.piappstudio.offlineexam.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import com.piappstudio.offlineexam.R
import com.piappstudio.offlineexam.common.Resource
import com.piappstudio.offlineexam.databinding.ActivityMainBinding
import com.piappstudio.offlineexam.model.pojo.Page
import com.piappstudio.offlineexam.ui.list.ListFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : PIBaseActivity() {

    lateinit var binding:ActivityMainBinding
    val viewModel:MainViewModel by lazy { MainViewModel() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        initUI()

    }


    private fun initUI() {
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

                        }
                        loadFragment(it.data?.page)
                    }
                    else -> {
                        dismissProgressDialog("Loading")
                    }
                }
            })
        }
    }

    private fun loadFragment(page:Page?) {
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