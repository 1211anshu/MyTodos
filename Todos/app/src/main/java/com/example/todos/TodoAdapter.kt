package com.example.todos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_task.*
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter (val list: List<TodoModel>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(todomodel: TodoModel) {
            with(itemView){
                val colors = resources.getIntArray(R.array.random_color)
                val randomColor = colors[Random().nextInt(colors.size)]
                viewColorTag.setBackgroundColor(randomColor)
                txtShowTitle.text = todomodel.title
                txtShowTask.text = todomodel.description
                txtShowCategory.text = todomodel.category
                updateTime(todomodel.time)
                updateDate(todomodel.date)
            }
        }
        private fun updateTime(time:Long) {
            val myformat = "h:mm a"
            val sdf = SimpleDateFormat(myformat)
            itemView.txtShowTime.text = (sdf.format(Date(time)))
        }

        private fun updateDate(time:Long) {
            val myformat = "EEE, d, MMM yyyy"
            val sdf = SimpleDateFormat(myformat)
            itemView.txtShowDate.text = (sdf.format(Date(time)))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(list[position])
    }

}
