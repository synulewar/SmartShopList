package com.synowkrz.shoplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.synowkrz.shoplist.basicElements.AddProductItemList
import com.synowkrz.shoplist.basicElements.AreaItemList
import com.synowkrz.shoplist.basicElements.ProductItemList
import com.synowkrz.shoplist.ui.theme.SmartShopListTheme

class ShopActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartShopListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        val productList = viewModel.products.value
                        ProductItemList(products = productList, onCheckChange = viewModel::onProductClicked)
                        Spacer(modifier = Modifier.height(16.dp))

                        val areas = viewModel.areas.value
                        AreaItemList(areas = areas, onPositionIncreased = viewModel::onPositionIncreased)
                        Spacer(modifier = Modifier.height(16.dp))

                        val addProducts = viewModel.addProdutcs.value
                        AddProductItemList(
                            produtcs = addProducts,
                            onAddClick = viewModel::onAddClick,
                            onIncreaseClick = viewModel::onIncreaseClick,
                            onDecreaseClick = viewModel::onDecreaseClick
                        )
                    }
                }
            }
        }
    }
}