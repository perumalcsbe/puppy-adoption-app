/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Segment
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.Lavender2
import com.example.androiddevchallenge.ui.theme.Shadow3
import com.example.androiddevchallenge.ui.utils.horizontalGradientBackground
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun PetAdaptionAppBar() {
    TopAppBar(
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
        modifier = Modifier.height(80.dp).horizontalGradientBackground(listOf(Lavender2, Shadow3)),
        contentColor = Color.White
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically).padding(top = 16.dp),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Filled.Segment,
                contentDescription = "profile"
            )
        }
        Row(
            modifier = Modifier.padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Puppy Adoption",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 20.dp).statusBarsPadding()
            )
        }
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically).padding(top = 16.dp),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "profile"
            )
        }
    }
}
