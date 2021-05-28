package com.indovision.belanja.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.indovision.belanja.data.CartEntity
import com.indovision.belanja.databinding.ItemCartListBinding

class CartAdapter(private val cartList: List<CartEntity>) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCartListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cartList[position])
    }

    override fun getItemCount(): Int = cartList.size

    class ViewHolder(private val binding: ItemCartListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cartEntity: CartEntity) {
            with(binding) {
                productTitle.text = cartEntity.name
                cartPrice.text = cartEntity.price
                cartQty.text = cartEntity.quantity
                cartSubtotal.text =
                    ((cartEntity.quantity.toInt()) * (cartEntity.price.toInt())).toString()

                Glide.with(itemView.context).apply { RequestOptions.overrideOf(100, 100) }
                    .load(cartEntity.imagePath).into(cartProductImages)

                buttonQtyPlus.setOnClickListener { buttonQtyClicked('+') }
                buttonQtyMinus.setOnClickListener { buttonQtyClicked('-') }
            }
        }

        private fun buttonQtyClicked(operation: Char) {
            with(binding){
                val price = cartPrice.text.toString().toInt()
                var quantity = cartQty.text.toString().toInt()

                when(operation){
                    '+' -> quantity = quantity + 1
                    '-' -> quantity = quantity - 1
                }

                cartQty.text = quantity.toString()
                cartSubtotal.text = (quantity * price).toString()
            }
        }
    }
}