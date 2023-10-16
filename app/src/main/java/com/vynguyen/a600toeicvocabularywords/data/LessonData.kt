package com.vynguyen.a600toeicvocabularywords.data

import com.vynguyen.a600toeicvocabularywords.R
import com.vynguyen.a600toeicvocabularywords.home.Lesson

object LessonData {

    fun getLessonData(): MutableList<Lesson> {
        val data: MutableList<Lesson> = mutableListOf()
        for (i: Int in 0..50) {
            data.add(Lesson(R.drawable.ic_dictionary, "Contrast $i"))
        }
        return data
    }
}