package com.battermind.aug2024bootcamp.ui.program.list



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.battermind.aug2024bootcamp.R
import com.battermind.aug2024bootcamp.database.model.ProgramModel

class ProgramAdapter(private val programs: List<ProgramModel>,private val call:(item:ProgramModel)->Unit) :
    RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder>() {
    class ProgramViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val programName: TextView = view.findViewById(R.id.txtTitle)
        val courseDetail : Button = view.findViewById(R.id.btnViewCourse)
        val duration: TextView = view.findViewById(R.id.txtDuration)
        val description: TextView = view.findViewById(R.id.txt_description)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_program, parent, false)
        return ProgramViewHolder(view)
    }
    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        val program = programs[position]
        holder.programName.text = program.title
        holder.duration.text = program.duration
        holder.description.text = program.description
        holder.courseDetail.setOnClickListener{call(program)}
    }
    override fun getItemCount() = programs.size
}
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        val programs = listOf(
//            Program("AI/ML 1 Day Workshop"),
//            Program("AI/ML Bootcamp"),
//            Program("App Development Internship Program"),
//            Program("Computer Science and Business Internship Program"),
//            Program("Computer Science and Business Internship Program")
//        )
//        val adapter = ProgramAdapter(programs)
//        recyclerView.adapter = adapter
//    }
//}