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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.Lavender6

@Composable
fun FeatureCard(
    backgroundColor: Color = MaterialTheme.colors.surface,
    sectionText: String,
    valueText: String
) {
    Card(
        backgroundColor = backgroundColor,
        elevation = 1.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(end = 12.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(sectionText, fontWeight = FontWeight.W700, color = Lavender6)
            Text(valueText, color = Color.Gray)
        }
    }
}
