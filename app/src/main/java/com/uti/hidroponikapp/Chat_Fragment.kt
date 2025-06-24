package com.uti.hidroponikapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uti.hidroponikapp.adapters.ChatAdapter
import com.uti.hidroponikapp.models.ChatItem

class Chat_Fragment : Fragment() {

    private lateinit var recyclerViewChats: RecyclerView
    private lateinit var searchEditText: EditText
    private lateinit var clearSearchButton: ImageView
    private lateinit var chatAdapter: ChatAdapter
    private var chatList = mutableListOf<ChatItem>()
    private var filteredChatList = mutableListOf<ChatItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        initViews(view)
        setupRecyclerView()
        setupSearchFunctionality()
        loadChatData()

        return view
    }

    private fun initViews(view: View) {
        recyclerViewChats = view.findViewById(R.id.recyclerViewChats)
        searchEditText = view.findViewById(R.id.searchEditText)
        clearSearchButton = view.findViewById(R.id.clearSearchButton)
    }

    private fun setupRecyclerView() {
        chatAdapter = ChatAdapter(filteredChatList) { chatItem ->
            onChatItemClicked(chatItem)
        }

        recyclerViewChats.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = chatAdapter
        }
    }

    private fun setupSearchFunctionality() {
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterChats(s.toString())
                clearSearchButton.visibility = if (s.isNullOrEmpty()) View.GONE else View.VISIBLE
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        clearSearchButton.setOnClickListener {
            searchEditText.text.clear()
        }
    }

    private fun filterChats(query: String) {
        filteredChatList.clear()
        if (query.isEmpty()) {
            filteredChatList.addAll(chatList)
        } else {
            chatList.forEach { chat ->
                if (chat.name.contains(query, ignoreCase = true) ||
                    chat.lastMessage.contains(query, ignoreCase = true)
                ) {
                    filteredChatList.add(chat)
                }
            }
        }
        chatAdapter.notifyDataSetChanged()
    }

    private fun loadChatData() {
        chatList.apply {
            add(ChatItem(
                id = 1,
                name = "Rusdi - Gardeners",
                lastMessage = "Lain kali papan catur kilo dan main dita...",
                time = "10:26 AM",
                profileImage = R.drawable.profile_rusdi,
                hasNotification = true,
                isOnline = false
            ))

            add(ChatItem(
                id = 2,
                name = "Andika - Dina's Garden",
                lastMessage = "You: lain kali aja, males gw",
                time = "Tuesday",
                profileImage = R.drawable.profile_andika,
                hasNotification = false,
                isOnline = false
            ))

            add(ChatItem(
                id = 3,
                name = "CentralPark",
                lastMessage = "Halo kak, welcome nih. Disini kamu bisa...",
                time = "1 week ago",
                profileImage = R.drawable.profile_centralpark,
                hasNotification = false,
                isOnline = false
            ))

            add(ChatItem(
                id = 4,
                name = "Ananta - Ananta Garden",
                lastMessage = "Lain kali papan catur kilo dan main dita...",
                time = "10:24 AM",
                profileImage = R.drawable.profile_ananta,
                hasNotification = true,
                isOnline = false
            ))

            add(ChatItem(
                id = 5,
                name = "Farchan - FarmGarden",
                lastMessage = "You: lain kali aja, males gw",
                time = "Tuesday",
                profileImage = R.drawable.profile_farchan,
                hasNotification = false,
                isOnline = false
            ))

            add(ChatItem(
                id = 6,
                name = "Hayah Dinah",
                lastMessage = "Halo kak, welcome nih. Disini kamu bisa...",
                time = "1 week ago",
                profileImage = R.drawable.profile_hayah,
                hasNotification = false,
                isOnline = true
            ))

            add(ChatItem(
                id = 7,
                name = "Farm Shop",
                lastMessage = "Lain kali papan catur kilo dan main dita...",
                time = "10:24 AM",
                profileImage = R.drawable.profile_farmshop,
                hasNotification = true,
                isOnline = false
            ))
        }

        filteredChatList.addAll(chatList)
        chatAdapter.notifyDataSetChanged()
    }

    private fun onChatItemClicked(chatItem: ChatItem) {
        // Tambahkan aksi navigasi atau detail chat di sini
    }

    override fun onResume() {
        super.onResume()
        // Jika perlu, bisa refresh status online/offline di sini
    }
}
