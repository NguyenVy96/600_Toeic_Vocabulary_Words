package com.vynguyen.a600toeicvocabularywords.home

data class Lesson(
    val imgResource: Int,
    val name: String,
    val vocabularyNumber: Int = 12,
    val score: Int = 0
)
