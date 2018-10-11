package me.hackathon.monicercustomerapp.ui.main.wallet

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import me.hackathon.monicercustomerapp.databinding.TransactionItemBinding
import me.hackathon.monicercustomerapp.vo.Transaction

class TransactionVH(val binding: TransactionItemBinding) : RecyclerView.ViewHolder(binding.root),
    View.OnClickListener {

  override fun onClick(v: View?) {

  }

  fun bind(transaction: Transaction) {
    binding.data = transaction
    binding.executePendingBindings()
  }
}