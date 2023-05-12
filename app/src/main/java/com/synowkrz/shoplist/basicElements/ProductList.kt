package com.synowkrz.shoplist.basicElements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.synowkrz.shoplist.R
import com.synowkrz.shoplist.data.Product
import com.synowkrz.shoplist.ui.theme.SmartShopListTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItem(
    product: Product,
    onCheckChange: (Product) -> Unit
) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 16.dp),
            painter = painterResource(id = product.icon),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = product.name
        )

        Checkbox(
            modifier = Modifier.padding(end = 8.dp),
            checked = false,
            onCheckedChange = {
                onCheckChange(product)
            }
        )
    }
}

@Composable
fun ProductItemList(
    products: List<Product>,
    onCheckChange: (Product) -> Unit
) {
    LazyColumn {
        items(products) {
            ProductItem(product = it, onCheckChange = onCheckChange)
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }
}


@Preview
@Composable
fun ProductItemPreview() {
    SmartShopListTheme {
        ProductItem(Product(0,"Bread", R.drawable.baseline_breakfast_dining_24)) {}
    }
}

@Preview
@Composable
fun ProductItemListPreview() {
    val products = listOf(
        Product(0, "Bread", R.drawable.baseline_breakfast_dining_24),
        Product(1, "Apple", R.drawable.baseline_breakfast_dining_24),
        Product(2, "Onion", R.drawable.baseline_breakfast_dining_24)
    )
    SmartShopListTheme {
        ProductItemList(products = products, onCheckChange = {})
    }
}