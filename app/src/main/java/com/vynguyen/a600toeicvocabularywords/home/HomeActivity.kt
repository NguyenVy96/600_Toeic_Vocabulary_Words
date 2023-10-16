package com.vynguyen.a600toeicvocabularywords.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.vynguyen.a600toeicvocabularywords.R
import com.vynguyen.a600toeicvocabularywords.databinding.ActivityHomeBinding


@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var viewBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setToolbar()
        showHomeFragment()
        setupNaviDrawer()
    }

    private fun setToolbar() {
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun showHomeFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_layout, HomeFragment())
        transaction.commit()
    }

    private fun setupNaviDrawer() {
        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            viewBinding.drawerLayout,
            viewBinding.toolbar,
            R.string.open_navi_drawer,
            R.string.close_navi_drawer
        )
        viewBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // TODO: need implement function

        return true
    }

    override fun onBackPressed() {
        if (viewBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            viewBinding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}