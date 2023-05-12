package com.synowkrz.shoplist.basicElements

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.synowkrz.shoplist.R
import com.synowkrz.shoplist.data.Area
import com.synowkrz.shoplist.data.AreaType
import com.synowkrz.shoplist.ui.theme.SmartShopListTheme

@Composable
fun AreaItem(area: Area, onPositionIncreased: (Area, Boolean) -> Unit) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            painter = painterResource(id = area.icon()),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = stringResource(id = area.displayName())
        )
        IconButton(
            onClick = { onPositionIncreased(area, true) },
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_upward_24),
                contentDescription = null,
            )
        }

        IconButton(
            onClick = { onPositionIncreased(area, false) },
            modifier = Modifier.padding(16.dp).size(24.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_downward_24),
                contentDescription = null
            )
        }
    }
}

@Composable
fun AreaItemList(
    areas: List<Area>,
    onPositionIncreased: (Area, Boolean) -> Unit
) {
    LazyColumn {
        items(areas) {
            AreaItem(area = it, onPositionIncreased)
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }
}

@Preview
@Composable
fun AreaItemPreview() {
    SmartShopListTheme {
        AreaItem(area = Area(AreaType.FRUITS_AND_VEGETABLES)) { area, increased ->  }
    }
}

@Preview
@Composable
fun AreaItemListPreview() {
    val list = listOf(
        Area(AreaType.FRUITS_AND_VEGETABLES),
        Area(AreaType.MEAT_AND_FISH),
        Area(AreaType.MILK_AND_DIARY)
    )
    SmartShopListTheme {
        AreaItemList(list) { area, increased ->  }
    }
}