package me.hackathon.monicercustomerapp.ui.main.wallet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.hackathon.monicercustomerapp.databinding.TransactionItemBinding
import me.hackathon.monicercustomerapp.vo.Transaction
import java.util.Locale

class TransactionsAdapter(private val transactions: List<Transaction> = ArrayList()) : RecyclerView.Adapter<TransactionVH>(){

  lateinit var context: Context

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): TransactionVH {
    context = parent.context
    val transactionBinding = TransactionItemBinding.inflate(LayoutInflater.from(context), parent, false)
    return TransactionVH(transactionBinding)
  }

  override fun getItemCount(): Int {
    return transactions.size
  }

  override fun onBindViewHolder(
    holder: TransactionVH,
    position: Int
  ) {
    holder.binding.data = transactions[position]
    if (position == 0) holder.binding.pullIcon.visibility = View.VISIBLE
    else holder.binding.pullIcon.visibility = View.GONE
  }

}