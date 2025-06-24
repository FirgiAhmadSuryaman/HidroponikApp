package com.example.app.models

data class ChatItem(
    val id: Int,
    val name: String,
    val lastMessage: String,
    val time: String,
    val profileImage: Int, // Resource ID untuk gambar profil
    val hasNotification: Boolean = false,
    val isOnline: Boolean = false,
    val unreadCount: Int = 0
)