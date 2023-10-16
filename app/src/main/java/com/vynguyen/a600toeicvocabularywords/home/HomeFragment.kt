package com.vynguyen.a600toeicvocabularywords.home

import android.content.Context
import android.content.res.Configuration
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vynguyen.a600toeicvocabularywords.R
import com.vynguyen.a600toeicvocabularywords.data.LessonData

class HomeFragment : Fragment(), LessonItemClickListener {

    private var rcvLesson: RecyclerView? = null
    private var lessonAdapter: LessonAdapter? = null
    private var listData: MutableList<Lesson>? = null
    private var context: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // get context from activity instead of parameter constructor to avoid FC when change theme
        context = activity?.applicationContext!!

        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        listData = LessonData.getLessonData()
        lessonAdapter = LessonAdapter(listData)
        lessonAdapter?.addItemCLickListener(this)
        rcvLesson = rootView.findViewById(R.id.rcv_lesson)
        rcvLesson?.layoutManager = LinearLayoutManager(context)
        rcvLesson?.adapter = lessonAdapter

        return rootView
    }

    override fun onDestroy() {
        clearData()
        super.onDestroy()
    }

    private fun clearData() {
        rcvLesson = null
        lessonAdapter = null
        listData = null
        context = null
    }

    override fun onClick(lesson: Lesson) {
        // TODO: Open detail lesson
        Toast.makeText(context, "CLicked " + lesson.name, Toast.LENGTH_SHORT).show()
        Log.d("ZZZ", "Clicked " + lesson.name)
    }

}