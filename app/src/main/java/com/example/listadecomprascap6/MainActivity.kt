package br.com.livrokotlin.listadecomprascap6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.view.View
import br.com.livrokotlin.listadecompras.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        binding.listViewProdutos.adapter = produtosAdapter

        binding.btnInserir.setOnClickListener {
            val produto = binding.txtProduto.text.toString()
            if (produto.isNotEmpty()) {
                produtosAdapter.add(produto)
                binding.txtProduto.text.clear()
            } else {
                binding.txtProduto.error = "Preencha um valor"
            }
        }

        binding.listViewProdutos.setOnItemLongClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true
        }
    }
}