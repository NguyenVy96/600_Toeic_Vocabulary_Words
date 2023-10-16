package com.vynguyen.a600toeicvocabularywords.home

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.vynguyen.a600toeicvocabularywords.R
import com.vynguyen.a600toeicvocabularywords.data.LessonData
import com.vynguyen.a600toeicvocabularywords.databinding.ActivityHomeBinding


@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity(), LessonItemClickListener, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var viewBinding: ActivityHomeBinding

    private var lessonAdapter: LessonAdapter? = null
    private var lessonListData: MutableList<Lesson>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setupToolbar()
        setupNaviDrawer()
        setupRecycleView()
    }

    private fun setupToolbar() {
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

    private fun setupRecycleView() {
        lessonListData = LessonData.getLessonData()
        lessonAdapter = LessonAdapter(lessonListData)
        lessonAdapter?.addItemCLickListener(this)
        viewBinding.rcvLesson.layoutManager = LinearLayoutManager(this)
        viewBinding.rcvLesson.adapter = lessonAdapter
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

    override fun onClick(lesson: Lesson) {
        // TODO: Open detail lesson

        Toast.makeText(this, "CLicked " + lesson.name, Toast.LENGTH_SHORT).show()
        Log.d("ZZZ", "Clicked " + lesson.name)
    }

    override fun onDestroy() {
        super.onDestroy()
        clearData()
    }
    
    private fun clearData() {
        lessonListData = null
        lessonAdapter = null
    }
}