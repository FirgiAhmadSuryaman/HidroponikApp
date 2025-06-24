package com.uti.hidroponikapp


import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uti.hidroponikapp.R

class ShopFragment : Fragment() {

    private lateinit var recyclerViewFertilizer: RecyclerView
    private lateinit var recyclerViewSeeds: RecyclerView
    private lateinit var fertilizerAdapter: ProductAdapter
    private lateinit var seedsAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setupRecyclerViews()
        loadData()
    }

    private fun initViews(view: View) {
        recyclerViewFertilizer = view.findViewById(R.id.recyclerViewFertilizer)
        recyclerViewSeeds = view.findViewById(R.id.recyclerViewSeeds)
    }

    private fun setupRecyclerViews() {
        // Setup RecyclerView untuk Pupuk Tanaman
        recyclerViewFertilizer.layoutManager = GridLayoutManager(context, 3)
        fertilizerAdapter = ProductAdapter { product ->
            onProductClick(product)
        }
        recyclerViewFertilizer.adapter = fertilizerAdapter

        // Setup RecyclerView untuk Benih/Seeds
        recyclerViewSeeds.layoutManager = GridLayoutManager(context, 3)
        seedsAdapter = ProductAdapter { product ->
            onProductClick(product)
        }
        recyclerViewSeeds.adapter = seedsAdapter
    }

    private fun loadData() {
        // Data Pupuk Tanaman Terbaru
        val fertilizerProducts = listOf(
            Product(
                id = 1,
                name = "Pupuk NPK",
                price = "Rp 25.000",
                originalPrice = "Rp 30.000",
                discount = "17%",
                imageResource = R.mipmap.bestseller_product,
                rating = 4.5f,
                sold = 120
            ),
            Product(
                id = 2,
                name = "Pupuk Organik",
                price = "Rp 15.000",
                originalPrice = "Rp 20.000",
                discount = "25%",
                imageResource = R.mipmap.bestseller_product,
                rating = 4.8f,
                sold = 85
            ),
            Product(
                id = 3,
                name = "Pupuk Kompos",
                price = "Rp 12.000",
                originalPrice = "Rp 15.000",
                discount = "20%",
                imageResource = R.mipmap.bestseller_product,
                rating = 4.3f,
                sold = 67
            )
        )

        // Data Benih/Seeds
        val seedProducts = listOf(
            Product(
                id = 4,
                name = "Benih Padi",
                price = "Rp 45.000",
                originalPrice = "Rp 50.000",
                discount = "10%",
                imageResource = R.mipmap.bestseller_product,
                rating = 4.7f,
                sold = 156
            ),
            Product(
                id = 5,
                name = "Benih Jagung",
                price = "Rp 35.000",
                originalPrice = "Rp 40.000",
                discount = "12%",
                imageResource = R.mipmap.bestseller_product,
                rating = 4.6f,
                sold = 98
            ),
            Product(
                id = 6,
                name = "Benih Cabai",
                price = "Rp 25.000",
                originalPrice = "Rp 28.000",
                discount = "11%",
                imageResource = R.mipmap.bestseller_product,
                rating = 4.4f,
                sold = 134
            )
        )

        fertilizerAdapter.submitList(fertilizerProducts)
        seedsAdapter.submitList(seedProducts)
    }

    private fun onProductClick(product: Product) {
        Toast.makeText(context, "Clicked: ${product.name}", Toast.LENGTH_SHORT).show()
        // Implement navigation to product detail or add to cart functionality
    }
}

// Model untuk Product
data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val originalPrice: String,
    val discount: String,
    val imageResource: Int,
    val rating: Float,
    val sold: Int
)

// Adapter untuk RecyclerView
class ProductAdapter(
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var products = listOf<Product>()

    fun submitList(newProducts: List<Product>) {
        products = newProducts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageProduct)
        private val textName: TextView = itemView.findViewById(R.id.textProductName)
        private val textPrice: TextView = itemView.findViewById(R.id.textPrice)
        private val textOriginalPrice: TextView = itemView.findViewById(R.id.textOriginalPrice)
        private val textDiscount: TextView = itemView.findViewById(R.id.textDiscount)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        private val textSold: TextView = itemView.findViewById(R.id.textSold)

        fun bind(product: Product) {
            imageView.setImageResource(product.imageResource)
            textName.text = product.name
            textPrice.text = product.price
            textOriginalPrice.text = product.originalPrice
            textOriginalPrice.paintFlags = textOriginalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            textDiscount.text = product.discount
            ratingBar.rating = product.rating
            textSold.text = "${product.sold} terjual"

            itemView.setOnClickListener {
                onItemClick(product)
            }
        }
    }
}