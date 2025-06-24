package com.uti.hidroponikapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uti.hidroponikapp.models.ChatItem
import com.uti.hidroponikapp.R

class ChatAdapter(
    private val chatList: List<ChatItem>,
    private val onItemClick: (ChatItem) -> Unit
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatItem = chatList[position]
        holder.bind(chatItem)
    }

    override fun getItemCount(): Int = chatList.size

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val lastMessageTextView: TextView = itemView.findViewById(R.id.lastMessageTextView)
        private val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        private val notificationIndicator: View = itemView.findViewById(R.id.notificationIndicator)
        private val onlineIndicator: View = itemView.findViewById(R.id.onlineIndicator)

        fun bind(chatItem: ChatItem) {
            // Set profile image
            profileImage.setImageResource(chatItem.profileImage)

            // Set name
            nameTextView.text = chatItem.name

            // Set last message
            lastMessageTextView.text = chatItem.lastMessage

            // Set time
            timeTextView.text = chatItem.time

            // Set notification indicator
            notificationIndicator.visibility = if (chatItem.hasNotification) View.VISIBLE else View.GONE

            // Set online indicator
            onlineIndicator.visibility = if (chatItem.isOnline) View.VISIBLE else View.GONE

            // Handle click
            itemView.setOnClickListener {
                onItemClick(chatItem)
            }

            // Set text color based on notification status
            if (chatItem.hasNotification) {
                nameTextView.setTextColor(itemView.context.getColor(R.color.text_primary))
                lastMessageTextView.setTextColor(itemView.context.getColor(R.color.text_primary))
            } else {
                nameTextView.setTextColor(itemView.context.getColor(R.color.text_primary))
                lastMessageTextView.setTextColor(itemView.context.getColor(R.color.text_secondary))
            }
        }
    }
}