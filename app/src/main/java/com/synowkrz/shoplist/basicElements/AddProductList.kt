package com.synowkrz.shoplist.basicElements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.synowkrz.shoplist.R
import com.synowkrz.shoplist.data.Product
import com.synowkrz.shoplist.ui.theme.SmartShopListTheme

@Composable
fun AddProductItemList(
    produtcs: List<Product>,
    onAddClick: (Product) -> Unit,
    onIncreaseClick: (Product) -> Unit,
    onDecreaseClick: (Product) -> Unit,
) {
    LazyColumn {
        items(produtcs) {
            AddProductItem(
                product = it,
                onAddClick = onAddClick,
                onIncreaseClick = onIncreaseClick,
                onDecreaseClick = onDecreaseClick
            )
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }
}

@Composable
fun AddProductItem(
    product: Product,
    onAddClick: (Product) -> Unit,
    onIncreaseClick: (Product) -> Unit,
    onDecreaseClick: (Product) -> Unit,
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

        Box(
            modifier = Modifier
                .size(height = 60.dp, width = 120.dp),
            contentAlignment = Alignment.Center
        ) {
            if (product.amount > 0) {
                IncreaseDecreaseButton(
                    product = product,
                    onIncreaseClick = onIncreaseClick,
                    onDecreaseClick = onDecreaseClick
                )
            } else {
                AddButton(product = product, onAddClick = onAddClick)
            }
        }
    }
}

@Composable
fun AddButton(
    product: Product,
    onAddClick: (Product) -> Unit
) {
    TextButton(
        border = BorderStroke(1.dp, Color.Black),
        onClick = { onAddClick(product) }
    ) {
        Text(text = stringResource(id = R.string.add_button_text))
    }
}

@Composable
fun IncreaseDecreaseButton(
    product: Product,
    onIncreaseClick: (Product) -> Unit,
    onDecreaseClick: (Product) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { onDecreaseClick(product) }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_remove_24),
                contentDescription = null
            )
        }

        Text(modifier = Modifier.weight(1f), text = product.amount.toString(), textAlign = TextAlign.Center)

        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { onIncreaseClick(product) }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = null
            )
        }
    }

}

@Preview
@Composable
fun AddProductItemPreview() {
    Column {
        SmartShopListTheme {
            AddProductItem(
                product = Product(0, "Bread", R.drawable.baseline_breakfast_dining_24),
                onAddClick = {},
                onIncreaseClick = {},
                onDecreaseClick = {}
            )
        }

        SmartShopListTheme {
            AddProductItem(
                product = Product(0, "Bread", R.drawable.baseline_breakfast_dining_24, amount = 1),
                onAddClick = {},
                onIncreaseClick = {},
                onDecreaseClick = {}
            )
        }
    }

}