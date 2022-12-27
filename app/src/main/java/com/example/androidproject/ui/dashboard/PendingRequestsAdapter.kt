package com.example.androidproject.ui.dashboard

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.entities.Event
import java.util.*

class PendingRequestsAdapter (private  val  pendingrequestsList: ArrayList<Event>) :
    RecyclerView.Adapter<PendingRequestsAdapter.PendingRequestsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendingRequestsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pending_request_item, parent,false)
        return PendingRequestsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PendingRequestsViewHolder, position: Int) {
        val currentItem = pendingrequestsList[position]
        holder.title.text = currentItem.title
        holder.host.text = currentItem.host.username
        val dateformat =  SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH)
        holder.startDate.text = dateformat.format(currentItem.startDate)
        holder.endDate.text = dateformat.format(currentItem.endDate)
    }

    override fun getItemCount(): Int {
        return pendingrequestsList.size
    }
    class PendingRequestsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val host : TextView = itemView.findViewById(R.id.dashboard_pending_notification_label_host)
        val title : TextView = itemView.findViewById(R.id.dashboard_pending_notification_event_title)
        val startDate : TextView = itemView.findViewById(R.id.dashboard_pending_notification_label_start_date)
        val endDate : TextView = itemView.findViewById(R.id.dashboard_pending_notification_label_end_date)

    }
}