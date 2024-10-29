package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Jus Alpukat", "Jus alpukat creamy dan lezat, mengenyangkan dengan lemak sehat", drawable/jusalpukat.jpg),
            Food("Jus Buah Naga ", "Jus Buah Naga merah segar dengan rasa manis-asam, kaya antioksidan. Pilihan sehat untuk kesegaran seharian", drawable/jusnaga.jpg ),
            Food("Jus Jeruk", "Jus jeruk alami dengan rasa manis-asam dan kaya vitamin C. Pas untuk semangat harian", drawable/jusjeruk.jpg),
            Food("Jus Mangga", "Jus mangga manis tropis dengan vitamin A dan C, rasa khas yang memikat", drawable/jusmangga.jpg),
            Food("Jus Melon", "Jus melon dengan rasa manis lembut yang menyegarkan, kaya vitamin C dan serat", drawable/jusmelon.jpg),
            Food("Jus Semangka", "Jus semangka segar dan manis alami, cocok untuk melepas dahaga dan kaya akan hidrasi", drawable/jussemangka.jpg),
            Food("Jus Sirsak", "Jus sirsak manis-asam dengan aroma khas, kaya antioksidan dan vitamin. Segar dan sehat", drawable/jussirsak.jpg),
            Food("Jus Strawberry", "Jus strawberry manis-asam dengan vitamin C tinggi, segar dan menggoda", drawable/jusstawberry.jpg),
            Food("Jus Tomat", "Jus tomat segar dan gurih dengan banyak vitamin A dan C, cocok untuk kesehatan dan kesegaran", drawable/justomat.jpg),
            Food("Jus Pisang", "Jus pisang creamy dan lembut, kaya serat dan vitamin B6. Rasa manis alami yang mengenyangkan", drawable/juspisang.jpg),

        )

        adapter = FoodAdapter(foodList) { selectedFood ->

            val intent = Intent(this, OrderActivity::class.java)

            intent.putExtra("foodName", selectedFood.name)
            startActivity(intent)
        }
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}