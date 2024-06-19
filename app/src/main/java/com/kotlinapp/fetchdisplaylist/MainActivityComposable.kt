package com.kotlinapp.fetchdisplaylist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kotlinapp.fetchdisplaylist.api.response.ListContent


@Composable
fun ShowList(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    // getting the values from the viewModel
    val lists by mainViewModel.itemList
    val errorMessage by mainViewModel.errorMessage

    // Using a box to display either the list or the text based on APi response
    Box(modifier = modifier.fillMaxSize()) {
        if (errorMessage != null) {
            Text(
                text = errorMessage ?: "Unknown error",
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
                items(items = lists) { item ->
                    DisplayListItems(modifier, item)
                }
            }
        }
    }
}

@Composable
fun DisplayListItems(
    modifier: Modifier,
    itemInList: ListContent
) {
    // commenting it out since no context is needed as of now
//    val context = LocalContext.current
    Card(
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(itemInList)
    }
}

@Composable
private fun CardContent(itemContent: ListContent) {
    Row(modifier = Modifier.padding(12.dp)) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)

        ) {
            Text(
                text = "List Id -> " + itemContent.listId.toString(),
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Normal
                )
            )
            Text(
                text = ("Name -> " + itemContent.name),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            // commenting out id text since its not adding any value - but can be shown if needed
//            Text(color = Color.Green, text = "Id -> " + itemContent.id.toString())
        }
    }
}

// Preview of DisplayList
@Preview
@Composable
fun DisplayListItemsPreview() {
    DisplayListItems(modifier = Modifier, itemInList = ListContent(listId = 1, name = "Item 1", id = 123))
}

