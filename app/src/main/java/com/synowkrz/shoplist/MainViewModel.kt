package com.synowkrz.shoplist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.synowkrz.shoplist.data.Area
import com.synowkrz.shoplist.data.AreaType
import com.synowkrz.shoplist.data.Product

class MainViewModel : ViewModel() {

    private val _produtcs = mutableStateOf(emptyList<Product>())
    val products : State<List<Product>>
        get() = _produtcs

    private val _areas = mutableStateOf(emptyList<Area>())
    val areas : State<List<Area>>
        get() = _areas

    private val _addProdutcs = mutableStateOf(emptyList<Product>())
    val addProdutcs : State<List<Product>>
        get() = _addProdutcs

    init {
        _produtcs.value = listOf(
            Product(0, "Bread", R.drawable.baseline_breakfast_dining_24),
            Product(1, "Apple", R.drawable.baseline_breakfast_dining_24),
            Product(2, "Onion", R.drawable.baseline_breakfast_dining_24)
        )

        _areas.value = listOf(
            Area(AreaType.FRUITS_AND_VEGETABLES),
            Area(AreaType.MEAT_AND_FISH),
            Area(AreaType.MILK_AND_DIARY)
        )

        _addProdutcs.value = listOf(
            Product(0, "Bread", R.drawable.baseline_breakfast_dining_24, 0),
            Product(1, "Apple", R.drawable.baseline_breakfast_dining_24, 1),
            Product(2, "Onion", R.drawable.baseline_breakfast_dining_24, 2)
        )
    }

    fun onProductClicked(product: Product) {
        val list = _produtcs.value.toMutableList()
        list.let {
            it.remove(product)
            _produtcs.value = it
        }
    }

    fun onPositionIncreased(area: Area, increased: Boolean) {
        val list = _areas.value.toMutableList()
        val index = list.indexOf(area)
        list.remove(area)
        val newIndex = if (increased) index - 1 else index + 1
        when {
            newIndex < 0 -> list.add(0, area)
            newIndex > list.size -> list.add(area)
            else -> list.add(newIndex, area)
        }
        _areas.value = list
    }

    fun onAddClick(product: Product) {
        val list = _addProdutcs.value.toMutableList()
        val index = list.indexOf(product)
        list[index] = product.copy(amount = product.amount + 1)
        _addProdutcs.value = list
    }

    fun onIncreaseClick(product: Product) {
        val list = _addProdutcs.value.toMutableList()
        val index = list.indexOf(product)
        list[index] = product.copy(amount = product.amount + 1)
        _addProdutcs.value = list
    }

    fun onDecreaseClick(product: Product) {
        val list = _addProdutcs.value.toMutableList()
        val index = list.indexOf(product)
        list[index] = product.copy(amount = product.amount - 1)
        _addProdutcs.value = list
    }
}