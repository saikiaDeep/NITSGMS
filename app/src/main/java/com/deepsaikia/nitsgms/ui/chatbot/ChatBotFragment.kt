package com.deepsaikia.nitsgms.ui.chatbot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deepsaikia.nitsgms.adapters.ItemAdapter
import com.deepsaikia.nitsgms.databinding.FragmentChatbotBinding


class ChatBotFragment : Fragment() {

    private var _binding: FragmentChatbotBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var itemViewModel: ChatBotViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val chatBotViewModel =
            ViewModelProvider(this).get(ChatBotViewModel::class.java)

        _binding = FragmentChatbotBinding.inflate(inflater, container, false)
        val root: View = binding.root



        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        itemAdapter = ItemAdapter(emptyList())
        recyclerView.adapter = itemAdapter

        itemViewModel = ViewModelProvider(this).get(chatBotViewModel::class.java)
        itemViewModel.items.observe(viewLifecycleOwner) { items ->
            itemAdapter.updateItems(items)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}