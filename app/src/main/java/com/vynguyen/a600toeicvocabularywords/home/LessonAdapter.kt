package com.vynguyen.a600toeicvocabularywords.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.vynguyen.a600toeicvocabularywords.R
import java.lang.ref.WeakReference

class LessonAdapter(
    private val listData: MutableList<Lesson>?
) :
    RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private var itemClickListener = WeakReference<LessonItemClickListener>(null)

    class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemLayout: ConstraintLayout
        val imgLesson: ImageView
        val tvLessonName: TextView
        val tvVoNumber: TextView
        val tvScore: TextView
        val pbScore: ProgressBar

        init {
            itemLayout = itemView.findViewById(R.id.lesson_layout)
            imgLesson = itemView.findViewById(R.id.img_lesson)
            tvLessonName = itemView.findViewById(R.id.tv_lesson_name)
            tvVoNumber = itemView.findViewById(R.id.tv_vocabulary_number)
            tvScore = itemView.findViewById(R.id.tv_score)
            pbScore = itemView.findViewById(R.id.pb_score)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lession_item, parent, false)
        return LessonViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (listData == null) {
            return 0
        }
        return listData.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        if (listData == null) {
            return
        }

        val lesson = listData[position]
        holder.imgLesson.setImageResource(lesson.imgResource)
        holder.tvLessonName.text = "Lesson " + position + ": " + lesson.name
        holder.tvVoNumber.text = "Vocabulary: " + lesson.vocabularyNumber.toString()
        holder.tvScore.text = lesson.score.toString() + "%"
        holder.pbScore.progress = lesson.score
        holder.itemLayout.setOnClickListener {
            itemClickListener.get()?.onClick(lesson)
        }
    }

    fun addItemCLickListener(listener: LessonItemClickListener) {
        itemClickListener = WeakReference(listener)
    }
}